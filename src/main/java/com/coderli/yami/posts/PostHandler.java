package com.coderli.yami.posts;

import java.util.List;

/**
 * 博文处理器
 *
 * @author li.hzh
 * @date 16/2/24
 */
public interface PostHandler {

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

    /**
     * 自动根据最后一个博文作为模板,生成新的博文
     *
     * @return 生成的新的博文
     */
    Post autoNewPost(String fileName, String title, String... tags) throws Exception;


}
