package com.coderli.yami;

import com.coderli.yami.common.init.YamiInitializer;
import com.coderli.yami.config.ConfigInitializer;
import com.coderli.yami.ui.MainBoard;
import com.coderli.yami.ui.UIInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.util.Date;

/**
 * Yami启动程序
 *
 * @author li.hzh
 * @date 16/2/19
 */
public class YamiLauncher {

    private static Logger logger = LoggerFactory.getLogger(YamiLauncher.class);

    public static void main(String[] args) throws Exception {
        logger.info("启动Yami应用.{}", new Date());
        YamiInitializer.init();
    }

}
