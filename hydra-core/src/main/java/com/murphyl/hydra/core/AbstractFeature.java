package com.murphyl.hydra.core;

import com.murphyl.x.Feature;
import io.vertx.core.AbstractVerticle;

/**
 * -
 * author: murph
 * 2021/10/21 - 22:54
 */
public abstract class AbstractFeature extends AbstractVerticle implements Feature {

    @Override
    public void start() throws Exception {
        super.start();
    }
}
