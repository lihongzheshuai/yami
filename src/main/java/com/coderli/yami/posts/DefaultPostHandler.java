package com.coderli.yami.posts;

import com.coderli.yami.common.constant.PostConstants;
import com.coderli.yami.common.util.Asserts;
import com.coderli.yami.common.util.TimeUtil;
import com.coderli.yami.config.YamiConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author li.hzh
 * @date 16/2/24
 */
public class DefaultPostHandler implements PostHandler {

    private static Logger logger = LoggerFactory.getLogger(DefaultPostHandler.class);
    private static final String RELATIVE_PATH = "_posts";
    private YamiConfig config = YamiConfig.getConfig();
    private String postsPath;
    private PostConverter postConverter = new DefaultPostConverter();
    private TemplateHandler templateHandler = new DefaultTemplateHandler();

    public DefaultPostHandler() {
        this.postsPath = config.getSitePath().concat(RELATIVE_PATH);
    }

    @Override
    public List<Post> listPosts() {
        File[] postFiles = listPostFiles();
        return postConverter.convert(postFiles);
    }

    @Override
    public Post getLastPost() {
        File[] postFiles = listPostFiles();
        return postConverter.convert(postFiles[postFiles.length - 1]);
    }

    @Override
    public Post autoNewPost(String fileName, String title, String... tags) throws Exception {
        Template template = templateHandler.generateTemplate(getLastPost());
        Post post = newPost(template, fileName, title, tags);
        return post;
    }


    private Post newPost(Template template, String fileName, String title, String[] tags) throws IOException {
        Post post = new Post();
        File postDir = getPostDirectory();
        String postFileName = generatePostName(fileName);
        String postFilePath = postDir + File.separator + postFileName;
        File postFile = new File(postFilePath);
        if (postFile.exists()) {
            logger.error("文章[{}]已经存在,无法创建.", postFilePath);
            throw new IllegalArgumentException("文章已经存在.");
        }
        //创建新文件
        postFile.createNewFile();
        //写入头信息.
        writeHeaderToFile(postFile, title, tags, template);
        post.setRawFile(postFile);
        post.setPath(postFilePath);
        post.setName(postFileName);
        return post;
    }

    private void writeHeaderToFile(File postFile, String title, String[] tags, Template template) throws IOException {
        String path = postFile.getAbsolutePath();
        List<String> headerList = new ArrayList<>();
        //起始符
        headerList.add(PostConstants.HEADER_SEPERATOR);
        //layout
        String layoutLine = generateLine(PostConstants.HEADER_KEY_LAYOUT, template.getHeader(PostConstants.HEADER_KEY_LAYOUT));
        headerList.add(layoutLine);
        //标题
        String titleLine = generateLine(PostConstants.HEADER_KEY_TITLE, title);
        headerList.add(titleLine);
        //tags
        if (tags != null && tags.length != 0) {
            String tagLine = generateTagLine(tags);
            headerList.add(tagLine);
        }
        //date
        String dateValue = TimeUtil.getCurrentTimeStr(PostConstants.HEADER_DATE_PATTERN);
        String dateLine = generateLine(PostConstants.HEADER_KEY_DATE, dateValue);
        headerList.add(dateLine);
        //comments
        //layout
        String commentsLine = generateLine(PostConstants.HEADER_KEY_COMMENTS, template.getHeader(PostConstants.HEADER_KEY_COMMENTS));
        headerList.add(commentsLine);
        //ThreadKey
        int originKey = Integer.parseInt(template.getHeader(PostConstants.HEADER_KEY_THREAD_KEY));
        int newKey = originKey + 1;
        String threadKeyLine = generateLine(PostConstants.HEADER_KEY_THREAD_KEY, new Integer(newKey).toString());
        headerList.add(threadKeyLine);
        //结束符
        headerList.add(PostConstants.HEADER_SEPERATOR);
        Files.write(Paths.get(path, new String[0]), headerList, Charset.defaultCharset(), new OpenOption[0]);
    }

    private String generateTagLine(String[] tags) {
        String value = "[";
        for (int i = 0; i < tags.length; i++) {
            value += tags[i];
            if (i != tags.length - 1) {
                value += ",";
            }
        }
        value += "]";
        return generateLine(PostConstants.HEADER_KEY_TAG, value);
    }

    private String generateLine(String key, String value) {
        return key + PostConstants.HEADER_CONTENT_SEPERATOR + value;
    }

    private String generatePostName(String title) {
        Asserts.assertNotEmptyOrNull(title, "文章名为空.");
        String today = TimeUtil.getCurrentDay();
        String formatTile = title.replaceAll(" ", "-");
        return today + "-" + formatTile + PostConstants.POST_FILE_EXT;
    }


    private File[] listPostFiles() {
        File postDir = getPostDirectory();
        return postDir.listFiles();
    }

    private File getPostDirectory() {
        File dir = new File(postsPath);
        Asserts.FileAsserts.assertDirectory(dir);
        return dir;
    }
}
