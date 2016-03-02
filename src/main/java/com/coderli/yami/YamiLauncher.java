package com.coderli.yami;

import com.coderli.yami.common.constant.PostConstants;
import com.coderli.yami.common.init.YamiInitializer;
import com.coderli.yami.posts.DefaultPostHandler;
import com.coderli.yami.posts.PostHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
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
        postHandler.autoNewPost(fileName, title, tags);

    }

}
