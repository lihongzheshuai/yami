package com.coderli.yami;

import com.coderli.yami.common.init.YamiInitializer;
import com.coderli.yami.config.YamiConfig;
import com.coderli.yami.posts.DefaultPostHandler;
import com.coderli.yami.posts.Post;
import com.coderli.yami.posts.PostHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        overrideWithArgs(args);
        logger.info("启动Yami应用.{}", new Date());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        while (fileName == null || fileName.isEmpty()) {
            System.out.println("请输入文件名:");
            fileName = bufferedReader.readLine();
        }
        String title = null;
        while (title == null || title.isEmpty()) {
            System.out.println("请输入文章名:");
            title = bufferedReader.readLine();
        }
        String tagLine = null;
        while (tagLine == null || tagLine.isEmpty()) {
            System.out.println("请输入tags,以,分割:");
            tagLine = bufferedReader.readLine();
        }
        String[] tags = tagLine.split(",");
        PostHandler postHandler = new DefaultPostHandler();
        Post post = postHandler.autoNewPost(fileName, title, tags);
        logger.info("创建文件[{}]成功.", post.getName());
        // 打开文件
        openFile(post);
    }

    //TODO 不好的实现. 因为是在初始化后再次覆盖了site path的配置
    private static void overrideWithArgs(String[] args) {
        if (args != null && args.length > 0) {
            String sitePath = args[0];
            YamiConfig.getConfig().setSitePath(sitePath);
        }
    }

    private static void openFile(Post post) throws IOException {
        Desktop.getDesktop().open(post.getRawFile());
    }

}
