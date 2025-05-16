import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户注册界面类
 * 提供用户注册功能，包括手机号、身份证号、密码和确认密码的输入
 */
public class LogOn extends JFrame {
    // 存储已注册用户列表
    private static List<User> registeredUsers = new ArrayList<>();

    // UI组件声明
    private JTextField phoneField;            // 手机号输入框
    private JTextField idCardField;           // 身份证号输入框
    private JPasswordField passwordField;     // 密码输入框
    private JPasswordField confirmPasswordField; // 确认密码输入框
    private JButton registerButton;           // 注册按钮
    private JButton loginButton;              // 登录按钮

    /**
     * 构造函数
     */
    public LogOn() {
        initUI();  // 初始化用户界面
        setTitle("用户注册");  // 设置窗口标题
        setSize(400, 350);    // 设置窗口大小
        setLocationRelativeTo(null);  // 窗口居中显示
        setResizable(false);          // 禁止调整窗口大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 关闭窗口时退出程序
    }

    /**
     * 初始化用户界面
     */
    private void initUI() {
        // 设置窗口背景色为浅灰色
        getContentPane().setBackground(new Color(240, 240, 240));
        setLayout(null); // 使用绝对布局（null layout）

        /* 标题标签 */
        JLabel titleLabel = new JLabel("用户注册", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 24)); // 设置字体
        titleLabel.setForeground(Color.YELLOW); // 设置文字颜色为黄色
        titleLabel.setBounds(0, 20, 400, 30);  // 设置位置和大小
        add(titleLabel);  // 添加到窗口

        /* 手机号输入部分 */
        // 手机号标签（右对齐）
        JLabel phoneLabel = new JLabel("手机号：", SwingConstants.RIGHT);
        phoneLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        phoneLabel.setBounds(50, 70, 80, 25);
        add(phoneLabel);

        // 手机号输入框
        phoneField = new JTextField();
        phoneField.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        phoneField.setBounds(140, 70, 210, 25);
        add(phoneField);

        /* 身份证号输入部分 */
        // 身份证号标签（右对齐）
        JLabel idCardLabel = new JLabel("身份证号：", SwingConstants.RIGHT);
        idCardLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        idCardLabel.setBounds(50, 110, 80, 25);
        add(idCardLabel);

        // 身份证号输入框
        idCardField = new JTextField();
        idCardField.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        idCardField.setBounds(140, 110, 210, 25);
        add(idCardField);

        /* 密码输入部分 */
        // 密码标签（右对齐）
        JLabel passwordLabel = new JLabel("密码：", SwingConstants.RIGHT);
        passwordLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        passwordLabel.setBounds(50, 150, 80, 25);
        add(passwordLabel);

        // 密码输入框
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        passwordField.setBounds(140, 150, 210, 25);
        add(passwordField);

        /* 确认密码输入部分 */
        // 确认密码标签（右对齐）
        JLabel confirmLabel = new JLabel("确认密码：", SwingConstants.RIGHT);
        confirmLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        confirmLabel.setBounds(50, 190, 80, 25);
        add(confirmLabel);

        // 确认密码输入框
        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        confirmPasswordField.setBounds(140, 190, 210, 25);
        add(confirmPasswordField);

        /* 注册按钮 */
        registerButton = new JButton("注册");
        registerButton.setHorizontalAlignment(SwingConstants.CENTER); // 文本居中
        registerButton.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        registerButton.setBackground(Color.WHITE);  // 白色背景
        registerButton.setBounds(100, 240, 80, 30);
        registerButton.addActionListener(this::handleRegister); // 添加点击事件监听
        add(registerButton);

        /* 登录按钮 */
        loginButton = new JButton("登录");
        loginButton.setHorizontalAlignment(SwingConstants.CENTER); // 文本居中
        loginButton.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        loginButton.setBackground(Color.WHITE);  // 白色背景
        loginButton.setBounds(220, 240, 80, 30);
        loginButton.addActionListener(this::handleLogin); // 添加点击事件监听
        add(loginButton);
    }

    /**
     * 处理注册按钮点击事件
     * @param e 事件对象
     */
    private void handleRegister(ActionEvent e) {
        // 获取用户输入
        String phone = phoneField.getText().trim();
        String idCard = idCardField.getText().trim();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        // 验证输入
        if (!validateInput(phone, idCard, password, confirmPassword)) {
            return; // 验证失败则返回
        }

        // 检查用户是否已存在
        if (isUserExists(phone, idCard)) {
            showError("该手机号或身份证号已注册");
            return;
        }

        // 注册成功，添加用户到列表
        registeredUsers.add(new User(phone, password, idCard));
        showSuccess("注册成功");
        backToLogin(); // 返回登录界面
    }

    /**
     * 验证用户输入
     * @param phone 手机号
     * @param idCard 身份证号
     * @param password 密码
     * @param confirmPassword 确认密码
     * @return 验证通过返回true，否则返回false
     */
    private boolean validateInput(String phone, String idCard, String password, String confirmPassword) {
        // 非空检查
        if (phone.isEmpty() || idCard.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            showError("所有字段不能为空");
            return false;
        }

        // 手机号验证（11位数字）
        if (phone.length() != 11 || !phone.matches("\\d+")) {
            showError("手机号必须为11位数字");
            return false;
        }

        // 身份证号验证（18位）
        if (idCard.length() != 18) {
            showError("身份证号必须为18位");
            return false;
        }

        // 密码长度验证（6-18位）
        if (password.length() < 6 || password.length() > 18) {
            showError("密码长度必须为6-18位");
            return false;
        }

        // 密码一致性验证
        if (!password.equals(confirmPassword)) {
            showError("两次输入的密码不一致");
            return false;
        }

        return true; // 所有验证通过
    }

    /**
     * 检查用户是否已存在
     * @param phone 手机号
     * @param idCard 身份证号
     * @return 存在返回true，否则返回false
     */
    private boolean isUserExists(String phone, String idCard) {
        // 检查当前注册列表
        for (User user : registeredUsers) {
            if (user.getPhone().equals(phone) || user.getIdCard().equals(idCard)) {
                return true;
            }
        }

        // 检查预注册列表（从登录界面获取）
        for (User user : LogIn.getRegisteredUsers()) {
            if (user.getPhone().equals(phone) || user.getIdCard().equals(idCard)) {
                return true;
            }
        }

        return false; // 用户不存在
    }

    /**
     * 处理登录按钮点击事件
     * @param e 事件对象
     */
    private void handleLogin(ActionEvent e) {
        backToLogin(); // 返回登录界面
    }

    /**
     * 返回登录界面
     */
    private void backToLogin() {
        this.dispose(); // 关闭当前窗口
        new LogIn().setVisible(true); // 打开登录窗口
    }

    /**
     * 显示错误提示框
     * @param message 错误信息
     */
    private void showError(String message) {
        JOptionPane.showMessageDialog(
                this,           // 父组件
                message,        // 消息内容
                "错误",          // 标题
                JOptionPane.ERROR_MESSAGE // 消息类型
        );
    }

    /**
     * 显示成功提示框
     * @param message 成功信息
     */
    private void showSuccess(String message) {
        JOptionPane.showMessageDialog(
                this,           // 父组件
                message,        // 消息内容
                "成功",         // 标题
                JOptionPane.INFORMATION_MESSAGE // 消息类型
        );
    }

    /**
     * 获取已注册用户列表
     * @return 用户列表
     */
    public static List<User> getRegisteredUsers() {
        return registeredUsers;
    }
}