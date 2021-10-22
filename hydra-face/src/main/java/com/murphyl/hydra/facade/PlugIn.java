package com.murphyl.hydra.facade;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 插件 - 描述
 *
 * @date: 2021/10/21 14:21
 * @author: murph
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PlugIn {

    Class[] value() default {};

}
