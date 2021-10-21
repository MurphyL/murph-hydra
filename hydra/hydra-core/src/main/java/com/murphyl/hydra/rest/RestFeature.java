package com.murphyl.hydra.rest;

import com.murphyl.hydra.core.AbstractFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * REST - 门面
 *
 * @date: 2021/10/21 10:38
 * @author: murph
 */
public class RestFeature extends AbstractFeature {

    private static final Logger logger = LoggerFactory.getLogger(RestFeature.class);

    @Override
    public void execute() {
        logger.info("正在注册 REST 模块");
    }

}
