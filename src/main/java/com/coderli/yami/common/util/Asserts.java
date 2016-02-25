package com.coderli.yami.common.util;

import com.google.common.base.Strings;

import java.io.File;

/**
 * 断言工具类
 *
 * @author li.hzh
 * @date 16/2/24
 */
public class Asserts {

    /**
     * 断言给定的字符串非空
     *
     * @param str
     * @param msg 异常信息
     */
    public static void assertNotEmptyOrNull(String str, String msg) {
        if (Strings.isNullOrEmpty(str)) {
            throw new IllegalArgumentException(msg);
        }

    }

    public static void assertNotNull(Object obj) {
        if(obj == null) {
            throw new IllegalArgumentException("输入的参数为空.");
        }
    }

    public static class FileAsserts {
        public static void assertDirectory(File dir) {
            assertNotNull(dir);
            if (!dir.exists()) {
                throw new IllegalArgumentException("目录[" + dir.getAbsolutePath() + "]不存在.");
            }
            if (!dir.isDirectory()) {
                throw new IllegalArgumentException("地址[" + dir.getAbsolutePath() + "]非目录.");
            }
        }
    }


}
