package com.murphyl.x;

/**
 * 可插拔 - 模块
 *
 * @date: 2021/10/20 20:09
 * @author: murph
 */
public interface MurphFeature {

    default void log() {
        System.out.println(getClass());
    }

}
