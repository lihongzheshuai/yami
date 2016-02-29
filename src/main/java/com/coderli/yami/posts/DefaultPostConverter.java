package com.coderli.yami.posts;

import com.coderli.yami.common.util.Asserts;

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
            posts.add(convert(postFile));
        }
        return posts;
    }

    @Override
    public Post convert(File file) {
        Asserts.assertNotNull(file);
        Post post = new Post();
        post.setName(file.getName());
        post.setPath(file.getAbsolutePath());
        post.setRawFile(file);
        return post;
    }


}
