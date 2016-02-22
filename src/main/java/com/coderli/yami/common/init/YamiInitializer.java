package com.coderli.yami.common.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 应用初始化器
 *
 * @author li.hzh
 * @date 16/2/22
 */
public class YamiInitializer {

    private static Logger logger = LoggerFactory.getLogger(YamiInitializer.class);

    private static final List<Initializer> initializers = new ArrayList<>();

    public static void init() {
        for (Initializer initializer : initializers) {
            logger.debug("执行初始化器:[{}].", initializer.getClass().getName());
            initializer.init();
        }
    }

}
