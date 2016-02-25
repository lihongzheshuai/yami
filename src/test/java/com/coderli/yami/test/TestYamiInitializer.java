package com.coderli.yami.test;

import com.coderli.yami.common.init.Initializer;
import com.coderli.yami.config.ConfigInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试用初始化器
 *
 * @author li.hzh
 * @date 16/2/25
 */
public class TestYamiInitializer {

    private static Logger logger = LoggerFactory.getLogger(TestYamiInitializer.class);

    private static final List<Initializer> initializers = new ArrayList<>();

    static {
        initializers.add(new ConfigInitializer());
    }

    public static void init() throws Exception {
        for (Initializer initializer : initializers) {
            logger.debug("执行初始化器:[{}].", initializer.getClass().getName());
            initializer.init();
        }
    }
}
