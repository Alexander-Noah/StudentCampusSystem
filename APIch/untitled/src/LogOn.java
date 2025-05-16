import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class LogOn extends JFrame {
    private static List<User> registeredUsers = new ArrayList<>();

    // UI组件
    private JTextField phoneField;
    private JTextField idCardField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton registerButton;
    private JButton loginButton;

    public LogOn() {
        initUI();
        setTitle("用户注册");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initUI() {
        // 设置浅灰色背景
        getContentPane().setBackground(new Color(240, 240, 240));
        setLayout(null);

        // 标题 - 黄色字体，居中显示
        JLabel titleLabel = new JLabel("用户注册", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
        titleLabel.setForeground(Color.YELLOW);
        titleLabel.setBounds(0, 20, 400, 30);
        add(titleLabel);

        // 手机号输入 - 标签右对齐
        JLabel phoneLabel = new JLabel("手机号：", SwingConstants.RIGHT);
        phoneLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        phoneLabel.setBounds(50, 70, 80, 25);
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        phoneField.setBounds(140, 70, 210, 25);
        add(phoneField);

        // 身份证号输入 - 标签右对齐
        JLabel idCardLabel = new JLabel("身份证号：", SwingConstants.RIGHT);
        idCardLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        idCardLabel.setBounds(50, 110, 80, 25);
        add(idCardLabel);

        idCardField = new JTextField();
        idCardField.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        idCardField.setBounds(140, 110, 210, 25);
        add(idCardField);

        // 密码输入 - 标签右对齐
        JLabel passwordLabel = new JLabel("密码：", SwingConstants.RIGHT);
        passwordLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        passwordLabel.setBounds(50, 150, 80, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        passwordField.setBounds(140, 150, 210, 25);
        add(passwordField);

        // 确认密码输入 - 标签右对齐
        JLabel confirmLabel = new JLabel("确认密码：", SwingConstants.RIGHT);
        confirmLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        confirmLabel.setBounds(50, 190, 80, 25);
        add(confirmLabel);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        confirmPasswordField.setBounds(140, 190, 210, 25);
        add(confirmPasswordField);

        // 注册按钮 - 文本居中
        registerButton = new JButton("注册");
        registerButton.setHorizontalAlignment(SwingConstants.CENTER);
        registerButton.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        registerButton.setBackground(Color.WHITE);
        registerButton.setBounds(100, 240, 80, 30);
        registerButton.addActionListener(this::handleRegister);
        add(registerButton);

        // 登录按钮 - 文本居中
        loginButton = new JButton("登录");
        loginButton.setHorizontalAlignment(SwingConstants.CENTER);
        loginButton.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        loginButton.setBackground(Color.WHITE);
        loginButton.setBounds(220, 240, 80, 30);
        loginButton.addActionListener(this::handleLogin);
        add(loginButton);
    }

    private void handleRegister(ActionEvent e) {
        String phone = phoneField.getText().trim();
        String idCard = idCardField.getText().trim();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (!validateInput(phone, idCard, password, confirmPassword)) {
            return;
        }

        if (isUserExists(phone, idCard)) {
            showError("该手机号或身份证号已注册");
            return;
        }

        LogIn.registeredUsers[LogIn.userCount++] = (new User(phone, password, idCard));
        showSuccess("注册成功");
        backToLogin();
    }

    private boolean validateInput(String phone, String idCard, String password, String confirmPassword) {
        if (phone.isEmpty() || idCard.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            showError("所有字段不能为空");
            return false;
        }

        if (phone.length() != 11 || !phone.matches("\\d+")) {
            showError("手机号必须为11位数字");
            return false;
        }

        if (idCard.length() != 18) {
            showError("身份证号必须为18位");
            return false;
        }

        if (password.length() < 6 || password.length() > 18) {
            showError("密码长度必须为6-18位");
            return false;
        }

        if (!password.equals(confirmPassword)) {
            showError("两次输入的密码不一致");
            return false;
        }

        return true;
    }

    private boolean isUserExists(String phone, String idCard) {
        for (User user : registeredUsers) {
            if (user.getPhone().equals(phone) || user.getIdCard().equals(idCard)) {
                return true;
            }
        }

        for (User user : LogIn.getRegisteredUsers()) {
            if (user.getPhone().equals(phone) || user.getIdCard().equals(idCard)) {
                return true;
            }
        }

        return false;
    }

    private void handleLogin(ActionEvent e) {
        backToLogin();
    }

    private void backToLogin() {
        this.dispose();
        new LogIn().setVisible(true);
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(
                this,
                message,
                "错误",
                JOptionPane.ERROR_MESSAGE
        );
    }

    private void showSuccess(String message) {
        JOptionPane.showMessageDialog(
                this,
                message,
                "成功",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static List<User> getRegisteredUsers() {
        return registeredUsers;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LogOn().setVisible(true);
        });
    }
}