package com.coderli.yami.posts;

import java.util.List;

/**
 * 博文处理器
 *
 * @author li.hzh
 * @date 16/2/24
 */
public interface PostsHandler {

    /**
     * 获取所有博文列表
     *
     * @return
     */
    List<Post> listPosts();


}
