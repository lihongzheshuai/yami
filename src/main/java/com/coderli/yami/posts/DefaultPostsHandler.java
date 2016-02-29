package com.coderli.yami.posts;

import com.coderli.yami.common.util.Asserts;
import com.coderli.yami.config.YamiConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;

/**
 * @author li.hzh
 * @date 16/2/24
 */
public class DefaultPostsHandler implements PostsHandler {

    private static Logger logger = LoggerFactory.getLogger(DefaultPostsHandler.class);
    private static final String RELATIVE_PATH = "_posts";
    private YamiConfig config = YamiConfig.getConfig();
    private String postsPath;
    private PostConverter postConverter = new DefaultPostConverter();

    public DefaultPostsHandler() {
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
