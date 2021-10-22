package com.murphyl.hydra.feature.rest;

import com.murphyl.hydra.core.FeatureVerticle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * REST - 门面
 *
 * @date: 2021/10/21 10:38
 * @author: murph
 */
public class RestFeature extends FeatureVerticle {

    private static final Logger logger = LoggerFactory.getLogger(RestFeature.class);

    @Override
    public void execute() {
        logger.info("正在发布 REST 服务");
        vertx.createHttpServer()
                .requestHandler(req -> {
                    req.response().end("hello !");
                })
                .listen(3030);
    }

}
