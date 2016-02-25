package com.coderli.yami.posts;

import java.io.File;
import java.util.List;

/**
 * 博文模型转换器, 用户把File文件根据规则,给Post模型对应的属性赋值
 *
 * @author li.hzh
 * @date 16/2/25
 */
public interface PostConverter {

    /**
     * 模型转换
     *
     * @param files
     * @return
     */
    List<Post> convert(File[] files);

}
