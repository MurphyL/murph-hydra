package com.murphyl.hydra.task;

import com.murphyl.hydra.facade.Feature;

/**
 * 任务插件 - 门面
 *
 * @date: 2021/10/20 20:14
 * @author: murph
 */
public class TaskFeature implements Feature {

    @Override
    public void execute() {
        System.out.println("hello");
    }
}
