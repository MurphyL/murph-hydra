package com.murphyl.hydra.feature.rest;

import com.murphyl.hydra.core.FeatureVerticle;
import com.murphyl.hydra.support.vertx.VertxCallback;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.http.HttpServerRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * REST - 门面
 *
 * @date: 2021/10/21 10:38
 * @author: murph
 */
public class RestFeature extends FeatureVerticle implements Handler<HttpServerRequest> {

    private static final Logger logger = LoggerFactory.getLogger(RestFeature.class);

    private static final HttpServerOptions options = new HttpServerOptions().setLogActivity(true);

    private int port = 3030;

    @Override
    public void execute() {
        VertxCallback callback = new VertxCallback(String.format("REST服务（%d）发布{}", port));
        vertx.createHttpServer(options).requestHandler(this).listen(port, callback);
    }

    @Override
    public void handle(HttpServerRequest request) {
        request.response().end("Hello, rest!");
    }
}
