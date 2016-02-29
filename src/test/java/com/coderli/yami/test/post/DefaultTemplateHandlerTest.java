package com.coderli.yami.test.post;

import com.coderli.yami.posts.DefaultPostsHandler;
import com.coderli.yami.posts.DefaultTemplateHandler;
import com.coderli.yami.posts.PostsHandler;
import com.coderli.yami.posts.TemplateHandler;
import com.coderli.yami.test.BaseYamiTest;
import org.junit.Before;
import org.junit.Test;

/**
 * @author li.hzh
 * @date 16/2/27
 */
public class DefaultTemplateHandlerTest extends BaseYamiTest {

    private TemplateHandler templateHandler = new DefaultTemplateHandler();
    private PostsHandler postsHandler = new DefaultPostsHandler();

    @Before
    public void init() {
        System.out.println();
    }

    @Test
    public void testGenerateTemplate() throws Exception {
        templateHandler.generateTemplate(postsHandler.getLastPost());
    }

}
