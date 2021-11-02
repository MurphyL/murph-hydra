package com.murphyl.hydra.feature.task;

import com.murphyl.hydra.core.FeatureVerticle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * 任务插件 - 门面
 *
 * @date: 2021/10/20 20:14
 * @author: murph
 */
public class TaskFeature extends FeatureVerticle {

    private static final Logger logger = LoggerFactory.getLogger(TaskFeature.class);

    @Override
    public void execute() {
        final ArrayBlockingQueue queue = new ArrayBlockingQueue(1000);
        logger.info("正在发布定时任务");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 5, TimeUnit.MINUTES, new ArrayBlockingQueue<>(100));
        executor.submit(() -> {
            do {
                Object object = queue.take();
                logger.info("task - {}", object);
            } while (true);
        });
        logger.info("任务发布完成");
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                queue.offer(UUID.randomUUID().toString());
            }
        }, 3000, 5000);
    }

}
