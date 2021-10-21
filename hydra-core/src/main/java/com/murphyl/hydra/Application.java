package com.murphyl.hydra;

import com.murphyl.hydra.core.AbstractFeature;
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

    @Override
    public void start(Promise<Void> startPromise) {
        Iterator<Feature> features = ServiceLoader.load(Feature.class).iterator();
        logger.info("开始发布动态模块……");
        while (features.hasNext()) {
            this.deploy(features.next());
        }
    }

    public void deploy(Feature feature) {
        if (feature instanceof AbstractFeature) {
            vertx.deployVerticle((Verticle) feature);
        } else {
            vertx.deployVerticle(new AbstractVerticle() {

                @Override
                public void start() {
                    feature.execute();
                    logger.info("尝试注册可插拔模块：{}", feature);
                }

            });
        }


    }

}
