package com.murphyl.hydra.feature.config;

import com.murphyl.hydra.core.FeatureVerticle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 配置 - 模块
 * author: murph
 * 2021/10/22 - 23:14
 */
public class ConfigFeature extends FeatureVerticle {

    private static final Logger logger = LoggerFactory.getLogger(ConfigFeature.class);

    @Override
    public void execute() {
        logger.info("配置中心");
    }

}
