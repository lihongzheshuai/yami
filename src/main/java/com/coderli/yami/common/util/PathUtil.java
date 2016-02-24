package com.coderli.yami.common.util;

import java.io.File;

/**
 * 文件路径处理工具类
 *
 * @author li.hzh
 * @date 16/2/24
 */
public class PathUtil {

    public static String appendSepratorIfNeed(String path) {
        Asserts.assertNotEmptyOrNull(path, "输入的路径为空,不合法.");
        if (!path.endsWith(File.separator)) {
            path = path.concat(File.separator);
        }
        return path;
    }

}
