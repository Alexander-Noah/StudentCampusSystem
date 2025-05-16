package 计算器;

    import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

    public class MainApp {
        public static void main(String[] args) {
            JFrame frame = new JFrame("多功能应用");
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // 使用卡片布局
            CardLayout cardLayout = new CardLayout();
            JPanel container = new JPanel(cardLayout);

            // 创建不同页面
            JPanel homePage = createPage("首页", Color.WHITE, "跳转到设置");
            JPanel settingsPage = createPage("设置", Color.LIGHT_GRAY, "返回首页");

            // 添加页面到容器
            container.add(homePage, "HOME");
            container.add(settingsPage, "SETTINGS");

            // 首页按钮事件
            ((JButton)homePage.getComponent(2)).addActionListener(e -> {
                cardLayout.show(container, "SETTINGS"); // 跳转到设置页
            });

            // 设置页按钮事件
            ((JButton)settingsPage.getComponent(2)).addActionListener(e -> {
                cardLayout.show(container, "HOME"); // 返回首页
            });

            frame.add(container);
            frame.setVisible(true);
        }

        private static JPanel createPage(String title, Color bgColor, String btnText) {
            JPanel panel = new JPanel(new BorderLayout());
            panel.setBackground(bgColor);

            // 标题
            JLabel label = new JLabel(title, SwingConstants.CENTER);
            label.setFont(new Font("微软雅黑", Font.BOLD, 24));
            panel.add(label, BorderLayout.NORTH);

            // 跳转按钮
            JButton button = new JButton(btnText);
            button.setPreferredSize(new Dimension(120, 40));
            panel.add(button, BorderLayout.SOUTH);

            return panel;
        }
    }
