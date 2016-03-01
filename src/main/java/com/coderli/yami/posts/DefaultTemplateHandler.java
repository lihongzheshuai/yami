package com.coderli.yami.posts;

import com.coderli.yami.common.constant.PostConstants;
import com.coderli.yami.common.util.Asserts;
import com.google.common.io.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
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
        boolean beginHeader = false;
        while ((line = reader.readLine()) != null) {
            if (!beginHeader && !PostConstants.HEADER_SEPERATOR.equals(line)) {
                logger.warn("当前文章的头格式不正确,无法正常解析.请以[{}]标记头信息.", PostConstants.HEADER_SEPERATOR);
                break;
            } else if (!beginHeader && PostConstants.HEADER_SEPERATOR.equals(line)) {
                //  读取第一行
                beginHeader = true;
                continue;
            } else if (beginHeader && PostConstants.HEADER_SEPERATOR.equals(line)) {
                // 读取到最后一行
                logger.info("文章头解析完毕.");
                break;
            } else {
                //解析头内容
                parseHeaderContent(line, template);
            }

        }

    }

    private void parseHeaderContent(String line, Template template) {
        String[] headerLine = line.split(PostConstants.HEADER_CONTENT_SEPERATOR);
        if (headerLine.length != 2) {
            logger.warn("头内容[{}]格式不正确,请检查是否以[{}]分隔.", line, PostConstants.HEADER_CONTENT_SEPERATOR);
            return;
        }
        template.setHeader(headerLine[0], headerLine[1].trim());
    }

}
