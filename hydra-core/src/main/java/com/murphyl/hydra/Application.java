package com.murphyl.hydra;

import com.murphyl.hydra.core.MixinFeature;
import com.murphyl.hydra.support.vertx.VerticleDeployHandler;
import com.murphyl.x.Feature;
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

    private static final Class[] HYDRA_FACES = {Verticle.class, Feature.class, MixinFeature.class};

    @Override
    public void start(Promise<Void> startPromise) {
        Iterator<Feature> features = ServiceLoader.load(Feature.class).iterator();
        logger.info("开始发布动态模块……");
        while (features.hasNext()) {
            this.deploy(features.next());
        }
    }

    public void deploy(Feature feature) {
        String unique = feature.getClass().getCanonicalName();
        if (feature instanceof AbstractVerticle) {
            vertx.deployVerticle((Verticle) feature, new VerticleDeployHandler(unique));
        } else {
            vertx.deployVerticle(new AbstractVerticle() {
                @Override
                public void start(Promise<Void> startPromise) throws Exception {
                    super.start(startPromise);
                    feature.execute();
                }
            }, new VerticleDeployHandler(unique));
        }
    }

}
