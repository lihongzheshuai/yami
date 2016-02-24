package com.coderli.yami.config;

import com.coderli.yami.common.init.AbstractInitializer;
import com.coderli.yami.common.init.Initializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * 配置信息初始化器
 *
 * @author li.hzh
 * @date 16/2/24
 */
public class ConfigInitializer extends AbstractInitializer implements Initializer {

    private static Logger logger = LoggerFactory.getLogger(ConfigInitializer.class);
    private static final String CONFIG_FILE_PATH = "/config/yami.properties";

    private static final String PROP_KEY_SITE_PATH = "yami.site.path";
    private Properties properties = new Properties();

    @Override
    public void init() throws Exception {
        logger.debug("开始初始化应用配置信息.");
        properties.load(this.getClass().getResourceAsStream(CONFIG_FILE_PATH));
        initYamiConfig();
    }

    /**
     * 初始化全局配置类
     */
    private void initYamiConfig() {
        YamiConfig config = YamiConfig.getConfig();
        config.setSitePath(properties.getProperty(PROP_KEY_SITE_PATH));
    }

    @Override
    public int getOrder() {
        return 1;
    }

}
