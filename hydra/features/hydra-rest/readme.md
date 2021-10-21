```text
vertx.createHttpServer().requestHandler(req -> {
    req.response().end("Hello from Vert.x!");
}).listen(8888, http -> {
    if (http.succeeded()) {
        startPromise.complete();
        logger.info("HTTP server started on port 8888");
    } else {
        startPromise.fail(http.cause());
    }
});
```
