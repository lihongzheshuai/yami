package com.coderli.yami.posts;

import java.util.HashMap;
import java.util.Map;

/**
 * 模板模型
 *
 * @author li.hzh
 * @date 16/2/24
 */
public class Template {

    // 模板头
    private Map<String, String> templateHeaders = new HashMap<>();

    public Map<String, String> getTemplateHeaders() {
        return templateHeaders;
    }

    public void setHeader(String key, String value) {
        this.templateHeaders.put(key, value);
    }

    public String getHeader(String key) {
        return this.templateHeaders.get(key);
    }
}
