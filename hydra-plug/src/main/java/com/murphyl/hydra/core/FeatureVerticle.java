package com.murphyl.hydra.core;

import com.murphyl.hydra.facade.HydraFeature;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 特征 - 模块
 *
 * @date: 2021/10/22 13:36
 * @author: murph
 */
public abstract class FeatureVerticle extends AbstractVerticle implements HydraFeature {

    private static final Logger logger = LoggerFactory.getLogger(FeatureVerticle.class);

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        super.start(startPromise);
        this.execute();
    }

    @Override
    public void execute() {
        logger.info("默认");
    }
}
