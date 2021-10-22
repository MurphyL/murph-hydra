package com.murphyl.hydra.facade;

/**
 * 可插拔 - 模块
 *
 * @date: 2021/10/20 20:09
 * @author: murph
 */
@FunctionalInterface
public interface Feature {

    /**
     * 开始执行
     */
    void execute();



}
