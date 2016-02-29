package com.coderli.yami.posts;

import com.coderli.yami.common.util.Asserts;
import com.google.common.io.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @author li.hzh
 * @date 16/2/26
 */
public class DefaultTemplateHandler implements TemplateHandler {

    private static Logger logger = LoggerFactory.getLogger(DefaultTemplateHandler.class);

    @Override
    public Template generateTemplate(Post post) throws Exception {
        Asserts.assertNotNull(post);
        Template template = new Template();
        parseHeader(post, template);
        return template;
    }

    private void parseHeader(Post post, Template template) throws IOException {
        BufferedReader reader = Files.newReader(post.getRawFile(), Charset.defaultCharset());
        String line = null;
        while ((line = reader.readLine()) != null) {
            logger.trace(line);
        }

    }

}
