package com.coderli.yami.posts;

import com.coderli.yami.config.YamiConfig;
import com.google.common.io.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    public DefaultPostsHandler() {
        this.postsPath = config.getSitePath();
    }

    @Override
    public List<Post> listPosts() {
        return null;
    }
}
