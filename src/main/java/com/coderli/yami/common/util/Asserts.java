package com.coderli.yami.common.util;

import com.google.common.base.Strings;

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


}
