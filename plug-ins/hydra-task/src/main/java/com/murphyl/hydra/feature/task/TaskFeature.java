package com.murphyl.hydra.feature.task;

import com.murphyl.hydra.facade.Feature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * 任务插件 - 门面
 *
 * @date: 2021/10/20 20:14
 * @author: murph
 */
public class TaskFeature implements Feature {


    private static final Logger logger = LoggerFactory.getLogger(TaskFeature.class);

    @Override
    public void execute() {
        ExecutorService executorService = new ThreadPoolExecutor(10, 20, 3000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
        logger.info("正在发布定时任务");
    }
}
