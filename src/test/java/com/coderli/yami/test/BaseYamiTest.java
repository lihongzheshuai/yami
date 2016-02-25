package com.coderli.yami.test;

import org.junit.BeforeClass;

/**
 * @author li.hzh
 * @date 16/2/25
 */
public class BaseYamiTest {

    @BeforeClass
    public static void initContext() throws Exception {
        TestYamiInitializer.init();
    }

}
