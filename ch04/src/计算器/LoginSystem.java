package 计算器;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginSystem {
    public static void main(String[] args) {
        // 创建登录界面
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }
}

class LoginFrame extends JFrame {
    public LoginFrame() {
        // 窗口设置
        setTitle("登录界面");
        setSize(300, 150);
        setResizable(false); // 禁止缩放
        setLocationRelativeTo(null); // 居中显示
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建组件
        JPanel panel = new JPanel(new GridLayout(3, 2));
        JLabel userLabel = new JLabel("用户名:");
        JLabel passLabel = new JLabel("密码:");
        userLabel.setForeground(Color.ORANGE); // 设置标签颜色
        passLabel.setForeground(Color.ORANGE);

        JTextField userField = new JTextField();
        JPasswordField passField = new JPasswordField();
        JButton loginButton = new JButton("登录");

        // 添加组件
        panel.add(userLabel);
        panel.add(userField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(new JLabel()); // 占位
        panel.add(loginButton);

        // 登录按钮事件
        loginButton.addActionListener(e -> {
            new CalculatorFrame().setVisible(true);
            dispose(); // 关闭登录界面
        });

        add(panel);
    }
}

class CalculatorFrame extends JFrame {
    private JTextField display = new JTextField("0");
    private double result = 0;
    private String operator = "=";
    private boolean calculating = true;

    public CalculatorFrame() {
        // 窗口设置
        setTitle("计算器");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 显示区域
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // 按钮面板
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(new ActionListener());
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
    }

    private class ActionListener implements java.awt.event.ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (calculating) {
                display.setText("");
                calculating = false;
            }

            if ('0' <= command.charAt(0) && command.charAt(0) <= '9' || command.equals(".")) {
                display.setText(display.getText() + command);
            } else {
                if (calculating) {
                    if (command.equals("-")) {
                        display.setText(command);
                        calculating = false;
                    } else {
                        operator = command;
                    }
                } else {
                    double x = Double.parseDouble(display.getText());
                    calculate(x);
                    operator = command;
                    calculating = true;
                }
            }
        }

        private void calculate(double x) {
            switch (operator) {
                case "+":
                    result += x;
                    break;
                case "-":
                    result -= x;
                    break;
                case "*":
                    result *= x;
                    break;
                case "/":
                    result /= x;
                    break;
                case "=":
                    result = x;
                    break;
            }
            display.setText("" + result);
        }
    }
}