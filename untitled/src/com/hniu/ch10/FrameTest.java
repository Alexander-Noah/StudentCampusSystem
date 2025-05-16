package com.hniu.ch10;

import javax.swing.*;

public class FrameTest {
    public static void main(String[] args) {
        JFrame frame=new JFrame();
        //设置关闭后退出
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置大小
        frame.setSize(300,300);
        //设置位置
        frame.setLocation(300,300);
        //设置大小和位置
        frame.setBounds(300,300,300,300);
        //设置窗体在屏幕正中间
        frame.setLocationRelativeTo(null);
        //标题设置，也可以在构造方法中传入
        frame.setTitle("Frame Test");
        //无放大和最小化按钮
        frame.setType(JFrame.Type.UTILITY);
        //设置禁止缩放
        frame.setResizable(false);
        //无边框
        frame.setUndecorated(true);
        //全屏显示
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frame.setVisible(true);//写在最后

    }
}


















