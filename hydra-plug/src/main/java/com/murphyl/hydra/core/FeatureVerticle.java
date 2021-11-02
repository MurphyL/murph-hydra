package com.murphyl.hydra.core;

import com.murphyl.hydra.facade.HydraFeature;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

/**
 * 特征 - 模块
 *
 * @date: 2021/10/22 13:36
 * @author: murph
 */
public abstract class FeatureVerticle extends AbstractVerticle implements HydraFeature {

    @Override
    public final void start(Promise<Void> startPromise) throws Exception {
        super.start(startPromise);
        this.execute();
    }

}
