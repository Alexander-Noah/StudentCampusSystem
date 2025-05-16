import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.List;

/**
 * 用户登录界面类
 */
public class LogIn extends JFrame {
    // 预注册用户数据（测试用）
    private static User[] registeredUsers = {
            new User("13987654321", "abcdef", "310101199102022345"), // 用户1
            new User("13812345679", "Abc123", "110101199001011234")  // 用户2
    };

    // UI组件声明
    private JTextField phoneField;         // 手机号输入框
    private JPasswordField passwordField;  // 密码输入框
    private JButton loginButton;          // 登录按钮
    private JButton registerButton;       // 注册按钮

    /**
     * 构造函数
     */
    public LogIn() {
        initUI();  // 初始化用户界面
        setTitle("用户登录");  // 设置窗口标题
        setSize(400, 300);    // 设置窗口大小
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
        JLabel titleLabel = new JLabel("用户登录", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 24)); // 设置字体
        titleLabel.setForeground(Color.YELLOW); // 设置文字颜色为黄色
        titleLabel.setBounds(0, 30, 400, 30);  // 设置位置和大小
        add(titleLabel);  // 添加到窗口

        /* 手机号输入部分 */
        // 手机号标签（右对齐）
        JLabel phoneLabel = new JLabel("手机号：", SwingConstants.RIGHT);
        phoneLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        phoneLabel.setBounds(50, 80, 100, 25);
        add(phoneLabel);

        // 手机号输入框
        phoneField = new JTextField();
        phoneField.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        phoneField.setBounds(160, 80, 160, 25);
        add(phoneField);

        /* 密码输入部分 */
        // 密码标签（右对齐）
        JLabel passwordLabel = new JLabel("密码：", SwingConstants.RIGHT);
        passwordLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        passwordLabel.setBounds(50, 120, 100, 25);
        add(passwordLabel);

        // 密码输入框
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        passwordField.setBounds(160, 120, 160, 25);
        add(passwordField);

        /* 登录按钮 */
        loginButton = new JButton("登入");
        loginButton.setHorizontalAlignment(SwingConstants.CENTER); // 文本居中
        loginButton.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        loginButton.setBackground(Color.WHITE);  // 白色背景
        loginButton.setBounds(100, 170, 80, 30);
        loginButton.addActionListener(this::handleLogin); // 添加点击事件监听
        add(loginButton);

        /* 注册按钮 */
        registerButton = new JButton("注册");
        registerButton.setHorizontalAlignment(SwingConstants.CENTER); // 文本居中
        registerButton.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        registerButton.setBackground(Color.WHITE);  // 白色背景
        registerButton.setBounds(220, 170, 80, 30);
        registerButton.addActionListener(this::handleRegister); // 添加点击事件监听
        add(registerButton);
    }

    /**
     * 处理登录按钮点击事件
     * @param e 事件对象
     */
    private void handleLogin(ActionEvent e) {
        // 获取输入的用户名和密码
        String phone = phoneField.getText().trim();
        String password = new String(passwordField.getPassword());

        // 输入验证
        if (phone.isEmpty() || password.isEmpty()) {
            showError("手机号和密码不能为空");
            return;
        }

        // 手机号格式验证
        if (phone.length() != 11) {
            showError("手机号必须为11位");
            return;
        }

        // 查找用户
        User user = findUserByPhone(phone);
        if (user == null) {
            showError("该手机号未注册");
            return;
        }

        // 密码验证
        if (!user.getPassword().equals(password)) {
            showError("密码错误");
            return;
        }

        // 登录成功，跳转到主界面
        Home.setCurrentUser(user);  // 设置当前用户
        this.dispose();             // 关闭登录窗口
        new Home().setVisible(true); // 显示主界面
    }

    /**
     * 处理注册按钮点击事件
     * @param e 事件对象
     */
    private void handleRegister(ActionEvent e) {
        this.dispose();            // 关闭当前窗口
        new LogOn().setVisible(true); // 打开注册窗口
    }

    /**
     * 根据手机号查找用户
     * @param phone 手机号
     * @return 用户对象，未找到返回null
     */
    private User findUserByPhone(String phone) {
        // 遍历预注册用户数组
        for (User user : registeredUsers) {
            if (user.getPhone().equals(phone)) {
                return user;  // 找到匹配用户
            }
        }
        return null;  // 未找到用户
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
     * 获取预注册用户列表
     * @return 用户列表
     */
    public static List<User> getRegisteredUsers() {
        return Arrays.asList(registeredUsers);  // 将数组转换为List
    }
}