package com.coderli.yami.test.post;

import com.coderli.yami.posts.DefaultPostHandler;
import com.coderli.yami.posts.Post;
import com.coderli.yami.posts.PostHandler;
import com.coderli.yami.test.BaseYamiTest;
import org.junit.Test;

import java.util.List;

/**
 * @author li.hzh
 * @date 16/2/25
 */
public class DefaultPostHandlerTest extends BaseYamiTest {

    private PostHandler postHandler = new DefaultPostHandler();

    @Test
    public void testListPosts() {
        List<Post> postList = postHandler.listPosts();
        for (Post post : postList) {
            System.out.println(post.getName());
        }
    }

    @Test
    public void testGetLastPost() {
        Post post = postHandler.getLastPost();
        System.out.println(post.getName());
    }

    @Test
    public void testAutoNewPost() throws Exception {
        String fileName = "chong gou jian hua and new mouse";
        String title = "重构,简化和新鼠标";
        String[] tags = new String[]{"OneCoder", "日记"};
        postHandler.autoNewPost(fileName, title, tags);
    }

}
