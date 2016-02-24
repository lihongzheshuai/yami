package com.coderli.yami.ui;

import com.coderli.yami.common.init.AbstractInitializer;
import com.coderli.yami.common.init.Initializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

/**
 * UI界面初始化器
 *
 * @author li.hzh
 * @date 16/2/24
 */
public class UIInitializer extends AbstractInitializer implements Initializer {

    private static Logger logger = LoggerFactory.getLogger(UIInitializer.class);

    @Override
    public void init(){
        logger.debug("开始初始化UI界面.");
        JFrame frame = new JFrame("MainBoard");
        frame.setContentPane(new MainBoard().getPanel1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }

}
