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
     * @return 博文列表, 没有的时候返回空列表.
     */
    List<Post> listPosts();


    /**
     * 获取最近发表的博文
     *
     * @return
     */
    Post getLastPost();
}
