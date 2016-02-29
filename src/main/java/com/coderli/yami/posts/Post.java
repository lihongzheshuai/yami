package com.coderli.yami.posts;

import java.io.File;
import java.util.Date;

/**
 * 博文模型
 *
 * @author li.hzh
 * @date 16/2/24
 */
public class Post {

    //博文名
    private String name;
    //路径
    private String path;
    //发表日期
    private Date postDate;
    //文件引用
    private File rawFile;

    public File getRawFile() {
        return rawFile;
    }

    public void setRawFile(File rawFile) {
        this.rawFile = rawFile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }
}
