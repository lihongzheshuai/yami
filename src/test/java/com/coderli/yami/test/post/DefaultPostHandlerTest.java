package com.coderli.yami.test.post;

import com.coderli.yami.posts.DefaultPostsHandler;
import com.coderli.yami.posts.Post;
import com.coderli.yami.posts.PostsHandler;
import com.coderli.yami.test.BaseYamiTest;
import org.junit.Test;

import java.util.List;

/**
 * @author li.hzh
 * @date 16/2/25
 */
public class DefaultPostHandlerTest extends BaseYamiTest {

    private PostsHandler postsHandler = new DefaultPostsHandler();

    @Test
    public void testListPosts() {
        List<Post> postList = postsHandler.listPosts();
        for (Post post : postList) {
            System.out.println(post.getName());
        }
    }

    @Test
    public void testGetLastPost() {
        Post post = postsHandler.getLastPost();
        System.out.println(post.getName());
    }


}
