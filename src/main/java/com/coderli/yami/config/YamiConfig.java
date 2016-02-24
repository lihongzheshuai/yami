package com.coderli.yami.config;

/**
 * Yami配置项
 *
 * @author li.hzh
 * @date 16/2/22
 */
public class YamiConfig {

    private static final YamiConfig config = new YamiConfig();

    // Jekyll网站根路径
    private String sitePath;

    public String getSitePath() {
        return sitePath;
    }

    public void setSitePath(String sitePath) {
        this.sitePath = sitePath;
    }

    /**
     * 返回配置实例
     *
     * @return
     */
    public static YamiConfig getConfig() {
        return config;
    }
}
