package com.murphyl.hydra;

import com.murphyl.hydra.core.MixinFeature;
import com.murphyl.hydra.facade.HydraFeature;
import com.murphyl.hydra.support.vertx.VertxCallback;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Verticle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 应用程序入口
 *
 * @author murph
 */
public final class Application extends AbstractVerticle {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    private static final Class[] HYDRA_FACES = {Verticle.class, HydraFeature.class, MixinFeature.class};

    @Override
    public void start(Promise<Void> startPromise) {
        Iterator<HydraFeature> features = ServiceLoader.load(HydraFeature.class).iterator();
        logger.info("开始发布动态模块……");
        while (features.hasNext()) {
            this.deploy(features.next());
        }
    }

    public void deploy(HydraFeature feature) {
        String unique = feature.getClass().getCanonicalName();
        VertxCallback callback = new VertxCallback("动态模块（" + unique + "）发布{}");
        if (feature instanceof AbstractVerticle) {
            vertx.deployVerticle((Verticle) feature, callback);
        } else {
            vertx.deployVerticle(new AbstractVerticle() {
                @Override
                public void start(Promise<Void> startPromise) throws Exception {
                    super.start(startPromise);
                    feature.execute();
                }
            }, callback);
        }
    }

}
