package com.coderli.yami.test.post;

import com.coderli.yami.posts.*;
import com.coderli.yami.test.BaseYamiTest;
import org.junit.Before;
import org.junit.Test;

/**
 * @author li.hzh
 * @date 16/2/27
 */
public class DefaultTemplateHandlerTest extends BaseYamiTest {

    private TemplateHandler templateHandler = new DefaultTemplateHandler();
    private PostHandler postHandler = new DefaultPostHandler();

    @Before
    public void init() {
        System.out.println();
    }

    @Test
    public void testGenerateTemplate() throws Exception {
        Template template = templateHandler.generateTemplate(postHandler.getLastPost());
        System.out.println(template.getTemplateHeaders());
    }

}
