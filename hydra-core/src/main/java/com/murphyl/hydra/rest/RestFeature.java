package com.murphyl.hydra.rest;

import com.murphyl.x.Feature;
import io.vertx.core.AbstractVerticle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * REST - 门面
 *
 * @date: 2021/10/21 10:38
 * @author: murph
 */
public class RestFeature extends AbstractVerticle implements Feature {

    private static final Logger logger = LoggerFactory.getLogger(RestFeature.class);

    public RestFeature() {
        logger.info("正在注册 REST 模块");
    }

    @Override
    public void execute() {

    }
}
