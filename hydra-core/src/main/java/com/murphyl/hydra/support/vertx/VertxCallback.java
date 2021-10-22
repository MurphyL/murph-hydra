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
public class VertxCallback<T> implements Handler<AsyncResult<T>> {

    private final static Logger logger = LoggerFactory.getLogger(VertxCallback.class);

    private String message;

    public VertxCallback(String  message) {
        this.message = message;
    }

    @Override
    public void handle(AsyncResult<T> event) {
        if (event.succeeded()) {
            logger.info(message, "成功");
        } else {
            logger.error(message, "失败", event.cause());
        }
    }
}
