package com.coderli.yami.common.init;

import com.coderli.yami.config.ConfigInitializer;
import com.coderli.yami.ui.UIInitializer;
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

    static {
        initializers.add(new ConfigInitializer());
//        initializers.add(new UIInitializer());
    }

    public static void init() throws Exception {
        for (Initializer initializer : initializers) {
            logger.debug("执行初始化器:[{}].", initializer.getClass().getName());
            initializer.init();
        }
    }

}
