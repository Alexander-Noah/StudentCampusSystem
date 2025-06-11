package com.studentcampus.student_module;

import javax.swing.*;
import java.awt.*;

public class SignInPageTwo extends JFrame {

    // 构造方法，用于初始化整个签到页面
    public SignInPageTwo() {
        // 设置窗体标题
        setTitle("课程签到界面");
        // 设置窗体大小（宽 950px，高 550px  ）
        setSize(950, 550);
        // 设置窗体关闭时的操作：关闭窗口并退出程序
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // 让窗体在屏幕上居中显示
        setLocationRelativeTo(null);
        // 将窗体内容面板的背景色设置为白色，让整体界面更贴近设计
        getContentPane().setBackground(Color.WHITE);
        // 使用绝对布局，方便精准控制每个组件的位置（适合还原固定设计的界面 ）
        setLayout(null);

        // ========== 返回按钮 ==========
        JButton returnBtn = new JButton("返回");
        // 设置按钮位置（距离左边 20px，距离上边 20px  ）和大小（宽 80px，高 30px  ）
        returnBtn.setBounds(20, 20, 80, 30);
        // 给按钮设置绿色边框，边框粗细为 2px
        returnBtn.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        // 按钮背景色设为白色
        returnBtn.setBackground(Color.WHITE);
        // 将按钮添加到窗体上
        add(returnBtn);

        // ========== 课程标题 ==========
        JLabel courseTitle = new JLabel("xx课  XX:XX-XX:XX");
        // 设置字体：黑体、加粗、24 号大小
        courseTitle.setFont(new Font("黑体", Font.BOLD, 24));
        // 设置标题位置（距离左边 280px，距离上边 15px  ）和显示区域大小（宽 300px，高 35px  ）
        courseTitle.setBounds(280, 15, 300, 35);
        add(courseTitle);

        // ========== 已签到统计文本 ==========
        JLabel signedLabel = new JLabel("已经签到：xx人");
        // 文字颜色设为橙色，突出显示统计信息
        signedLabel.setForeground(Color.ORANGE);
        // 字体：宋体、加粗、16 号大小
        signedLabel.setFont(new Font("宋体", Font.BOLD, 16));
        // 位置（距离左边 40px，距离上边 60px  ）和显示区域（宽 150px，高 25px  ）
        signedLabel.setBounds(40, 60, 150, 25);
        add(signedLabel);

        // ========== 未签到统计文本 ==========
        JLabel unsignedLabel = new JLabel("未签：xx人");
        signedLabel.setForeground(Color.ORANGE);
        unsignedLabel.setFont(new Font("宋体", Font.BOLD, 16));
        // 位置（距离左边 430px，距离上边 60px  ）和显示区域（宽 120px，高 25px  ）
        unsignedLabel.setBounds(430, 60, 120, 25);
        add(unsignedLabel);

        // ========== 已签到区域边框（黑色） ==========
        JComponent signedBorder = new JComponent() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // 设置绘制边框的颜色为黑色
                g.setColor(Color.BLACK);
                // 绘制矩形边框，参数：距离左边 40px、上边 85px，宽 350px，高 350px
                g.drawRect(40, 85, 350, 350);
            }
        };
        // 边框组件自身的显示区域（宽 400px，高 450px  ），用于承载绘制的矩形边框
        signedBorder.setBounds(0, 0, 400, 450);
        add(signedBorder);

        // ========== 已签到人员姓名展示 ==========
        String[] signedNames = {"张三", "李四", "赵六"};
        // 用于控制姓名标签的垂直位置，初始距离上边 100px
        int y = 100;
        for (String name : signedNames) {
            JLabel nameLbl = new JLabel(name);
            // 姓名文字颜色设为橙色
            nameLbl.setForeground(Color.ORANGE);
            // 字体：宋体、加粗、18 号大小
            nameLbl.setFont(new Font("宋体", Font.BOLD, 18));
            // 位置（距离左边 70px，垂直方向用 y 控制  ）和显示区域（宽 80px，高 30px  ）
            nameLbl.setBounds(70, y, 80, 30);
            add(nameLbl);
            // 每次循环让 y 增加 60px，控制下一个姓名标签的垂直间距
            y += 60;
        }

        // ========== 已签到分页按钮 - 上一页 ==========
        JButton signedPrev = new JButton("上一页");
        // 位置（距离左边 50px，距离上边 400px  ）和大小（宽 100px，高 30px  ）
        signedPrev.setBounds(50, 400, 100, 30);
        signedPrev.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        signedPrev.setBackground(Color.WHITE);
        add(signedPrev);

        // ========== 已签到分页按钮 - 下一页 ==========
        JButton signedNext = new JButton("下一页");
        // 位置（距离左边 280px，距离上边 400px  ）和大小（宽 100px，高 30px  ）
        signedNext.setBounds(280, 400, 100, 30);
        signedNext.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        signedNext.setBackground(Color.WHITE);
        add(signedNext);

        // ========== 未签到区域边框（橙色） ==========
        JComponent unsignedBorder = new JComponent() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // 设置绘制边框的颜色为橙色
                g.setColor(Color.ORANGE);
                // 绘制矩形边框，参数：距离左边 20px、上边 85px，宽 400px，高 350px
                g.drawRect(20, 85, 400, 350);
            }
        };
        // 边框组件自身的显示区域（宽 550px，高 450px  ）
        unsignedBorder.setBounds(400, 0, 550, 450);
        add(unsignedBorder);

        // ========== 未签到人员姓名及操作按钮 ==========
        String[] unsignedNames = {"王五", "不知道"};
        // 用于控制未签到人员标签和按钮的垂直位置，初始距离上边 100px
        y = 100;
        for (String name : unsignedNames) {
            JLabel nameLbl = new JLabel(name);
            nameLbl.setForeground(Color.ORANGE);
            nameLbl.setFont(new Font("宋体", Font.BOLD, 18));
            // 位置（距离左边 450px，垂直方向用 y 控制  ）和显示区域（宽 80px，高 30px  ）
            nameLbl.setBounds(450, y, 80, 30);
            add(nameLbl);

            // ---------- 教师代签按钮 ----------
            JButton teacherSign = new JButton("教师代签");
            teacherSign.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
            teacherSign.setBackground(Color.WHITE);
            // 位置（距离左边 570px，垂直方向比姓名标签靠上 5px  ）和大小（宽 110px，高 35px  ）
            teacherSign.setBounds(570, y - 5, 110, 35);
            add(teacherSign);

            // ---------- 设为请假按钮 ----------
            JButton leaveBtn = new JButton("设为请假");
            leaveBtn.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
            leaveBtn.setBackground(Color.WHITE);
            // 位置（距离左边 690px，垂直方向比姓名标签靠上 5px  ）和大小（宽 110px，高 35px  ）
            leaveBtn.setBounds(690, y - 5, 110, 35);
            add(leaveBtn);

            // 每次循环让 y 增加 60px，控制下一组未签到人员及按钮的垂直间距
            y += 60;
        }

        // ========== 未签到分页按钮 - 上一页 ==========
        JButton unsignedPrev = new JButton("上一页");
        // 位置（距离左边 430px，距离上边 400px  ）和大小（宽 100px，高 30px  ）
        unsignedPrev.setBounds(430, 400, 100, 30);
        unsignedPrev.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        unsignedPrev.setBackground(Color.WHITE);
        add(unsignedPrev);

        // ========== 未签到分页按钮 - 下一页 ==========
        JButton unsignedNext = new JButton("下一页");
        // 位置（距离左边 710px，距离上边 400px  ）和大小（宽 100px，高 30px  ）
        unsignedNext.setBounds(710, 400, 100, 30);
        unsignedNext.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        unsignedNext.setBackground(Color.WHITE);
        add(unsignedNext);
    }

    // main 方法，程序入口
    public static void main(String[] args) {
        // 借助 SwingUtilities.invokeLater，在事件调度线程中创建并显示窗体（避免线程安全问题 ）
        SwingUtilities.invokeLater(() -> {
            SignInPageTwo frame = new SignInPageTwo();
            // 让窗体可见
            frame.setVisible(true);
        });
    }
}