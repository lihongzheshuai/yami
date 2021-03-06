package com.coderli.yami.posts;

/**
 * 模板处理接口
 *
 * @author li.hzh
 * @date 16/2/26
 */
public interface TemplateHandler {

    /**
     * 根据博文生成模板
     *
     * @param post
     * @return
     */
    Template generateTemplate(Post post) throws Exception;

}
