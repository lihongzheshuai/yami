package com.coderli.yami.posts;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author li.hzh
 * @date 16/2/25
 */
public class DefaultPostConverter implements PostConverter {

    @Override
    public List<Post> convert(File[] files) {
        List<Post> posts = new ArrayList<>();
        if (files == null || files.length == 0) {
            return posts;
        }
        for (File postFile : files) {
            Post post = new Post();
            post.setName(postFile.getName());
            post.setPath(postFile.getAbsolutePath());
            posts.add(post);
        }
        return posts;
    }

}
