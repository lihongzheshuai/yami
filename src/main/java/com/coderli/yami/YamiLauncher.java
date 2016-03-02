package com.coderli.yami;

import com.coderli.yami.common.init.YamiInitializer;
import com.coderli.yami.posts.DefaultPostHandler;
import com.coderli.yami.posts.PostHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Yami启动程序
 *
 * @author li.hzh
 * @date 16/2/19
 */
public class YamiLauncher {

    private static Logger logger = LoggerFactory.getLogger(YamiLauncher.class);

    public static void main(String[] args) throws Exception {
        YamiInitializer.init();
        logger.info("启动Yami应用.{}", new Date());
        String fileName = "migrate blog again and new house property";
        String title = "20160302 博客再次迁移和房产证办理";
        String[] tags = new String[]{"OneCoder", "日记"};
        PostHandler postHandler = new DefaultPostHandler();
        postHandler.autoNewPost(fileName, title, tags);

    }

}
