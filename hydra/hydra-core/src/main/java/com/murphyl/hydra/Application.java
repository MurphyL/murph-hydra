package com.murphyl.hydra;

import com.murphyl.x.MurphFeature;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author murph
 */
public class Application extends AbstractVerticle {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Override
    public void start(Promise<Void> startPromise) {
        Iterator<MurphFeature> features = ServiceLoader.load(MurphFeature.class).iterator();
        logger.info("开始发布动态模块……");
        while (features.hasNext()) {
            this.deploy(features.next());
        }
    }

    public void deploy(MurphFeature feature) {
        logger.info(feature.toString());
    }

}
