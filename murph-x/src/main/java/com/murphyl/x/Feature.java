package com.murphyl.x;

import java.util.concurrent.Exchanger;

/**
 * 可插拔 - 模块
 *
 * @date: 2021/10/20 20:09
 * @author: murph
 */
public interface Feature {

    /**
     * 开始执行
     */
    void execute();
}
