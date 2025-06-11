package com.studentcampus.student_module;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignInPage extends JFrame {
    // 用于存储已签到学生的标签数组
    private JLabel[] studentLabels;
    private int currentPage = 0;
    private int totalPages = 1;
    private int studentsPerPage = 10;
    private String[] allStudents = {
            "张三", "李四", "王五", "赵六", "钱七", "孙八", "周九", "吴十",
            "郑十一", "王十二", "冯十三", "陈十四", "楚十五", "魏十六",
            "蒋十七", "沈十八", "韩十九", "杨二十"
    };

    public SignInPage() {
        // 设置窗口标题
        super("课程签到");

        // 设置窗口大小和关闭操作
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 设置整体布局为边界布局
        setLayout(new BorderLayout());

        // 创建顶部面板
        JPanel topPanel = createTopPanel();
        add(topPanel, BorderLayout.NORTH);

        // 创建学生列表面板
        JPanel studentPanel = createStudentPanel();
        add(studentPanel, BorderLayout.CENTER);

        // 创建底部导航面板
        JPanel bottomPanel = createBottomPanel();
        add(bottomPanel, BorderLayout.SOUTH);

        // 初始化学生列表
        updateStudentList();
    }

    private JPanel createTopPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 240, 240));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        // 返回按钮
        JButton backButton = new JButton("返回");
        backButton.setPreferredSize(new Dimension(80, 30));
        backButton.addActionListener(e -> System.exit(0)); // 实际应用中应该返回上一页

        // 课程信息
        JLabel courseLabel = new JLabel("Java程序设计  10:00-12:00");
        courseLabel.setFont(new Font("宋体", Font.BOLD, 16));

        // 签到统计
        JLabel signInStats = new JLabel("已签到: 15/30");
        signInStats.setForeground(new Color(255, 165, 0)); // 橙色
        signInStats.setFont(new Font("宋体", Font.BOLD, 14));

        // 添加组件到顶部面板
        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftPanel.add(backButton);
        leftPanel.add(Box.createHorizontalStrut(20));
        leftPanel.add(courseLabel);

        panel.add(leftPanel, BorderLayout.WEST);
        panel.add(signInStats, BorderLayout.EAST);

        return panel;
    }

    private JPanel createStudentPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // 创建学生标签数组
        studentLabels = new JLabel[studentsPerPage];
        for (int i = 0; i < studentsPerPage; i++) {
            studentLabels[i] = new JLabel("");
            studentLabels[i].setFont(new Font("宋体", Font.BOLD, 16));
            studentLabels[i].setForeground(new Color(255, 165, 0)); // 橙色
            studentLabels[i].setHorizontalAlignment(JLabel.CENTER);
            studentLabels[i].setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(220, 220, 220)),
                    BorderFactory.createEmptyBorder(15, 0, 15, 0)
            ));
            panel.add(studentLabels[i]);
        }

        return panel;
    }

    private JPanel createBottomPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 240, 240));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        // 上一页按钮
        JButton prevButton = new JButton("上一页");
        prevButton.setPreferredSize(new Dimension(100, 35));
        prevButton.addActionListener(e -> {
            if (currentPage > 0) {
                currentPage--;
                updateStudentList();
            }
        });

        // 下一页按钮
        JButton nextButton = new JButton("下一页");
        nextButton.setPreferredSize(new Dimension(100, 35));
        nextButton.addActionListener(e -> {
            if (currentPage < totalPages - 1) {
                currentPage++;
                updateStudentList();
            }
        });

        // 页码标签
        JLabel pageLabel = new JLabel("第 1 页 / 共 2 页");
        pageLabel.setFont(new Font("宋体", Font.PLAIN, 14));

        // 添加组件到底部面板
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(prevButton);
        buttonPanel.add(Box.createHorizontalStrut(20));
        buttonPanel.add(pageLabel);
        buttonPanel.add(Box.createHorizontalStrut(20));
        buttonPanel.add(nextButton);

        panel.add(buttonPanel, BorderLayout.CENTER);

        return panel;
    }

    private void updateStudentList() {
        // 计算总页数
        totalPages = (int) Math.ceil((double) allStudents.length / studentsPerPage);

        // 更新页码标签
        JLabel pageLabel = (JLabel) ((JPanel) ((JPanel) getContentPane().getComponent(2)).getComponent(0)).getComponent(2);
        pageLabel.setText("第 " + (currentPage + 1) + " 页 / 共 " + totalPages + " 页");

        // 更新上一页和下一页按钮状态
        JButton prevButton = (JButton) ((JPanel) ((JPanel) getContentPane().getComponent(2)).getComponent(0)).getComponent(0);
        JButton nextButton = (JButton) ((JPanel) ((JPanel) getContentPane().getComponent(2)).getComponent(0)).getComponent(4);
        prevButton.setEnabled(currentPage > 0);
        nextButton.setEnabled(currentPage < totalPages - 1);

        // 更新学生列表
        int startIndex = currentPage * studentsPerPage;
        for (int i = 0; i < studentsPerPage; i++) {
            int index = startIndex + i;
            if (index < allStudents.length) {
                studentLabels[i].setText(allStudents[index]);
                studentLabels[i].setVisible(true);
            } else {
                studentLabels[i].setVisible(false);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SignInPage().setVisible(true);
        });
    }
}
