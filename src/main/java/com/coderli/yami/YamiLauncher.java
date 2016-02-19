package com.coderli.yami;

import com.coderli.yami.ui.MainBoard;

import javax.swing.*;

/**
 * Yami启动程序
 *
 * @author li.hzh
 * @date 16/2/19
 */
public class YamiLauncher {

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("MainBoard");
        frame.setContentPane(new MainBoard().getPanel1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
