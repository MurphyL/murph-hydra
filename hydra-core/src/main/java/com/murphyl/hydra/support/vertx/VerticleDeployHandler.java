package com.murphyl.hydra.support.vertx;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * -
 *
 * @date: 2021/10/22 15:05
 * @author: murph
 */
public class VerticleDeployHandler implements Handler<AsyncResult<String>> {

    private final static Logger logger = LoggerFactory.getLogger(VerticleDeployHandler.class);

    private String unique;

    public VerticleDeployHandler(String unique) {
        this.unique = unique;
    }

    @Override
    public void handle(AsyncResult<String> event) {
        if (event.succeeded()) {
            logger.info("动态模块发布完成：{}", unique);
        } else {
            logger.info("动态模块发布失败：{}，{}", unique, event.cause());
        }
    }
}
