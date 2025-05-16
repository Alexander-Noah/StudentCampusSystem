import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.List;

public class LogIn extends JFrame {
    public static User[] registeredUsers = {
            new User("13987654321", "abcdef", "310101199102022345"),
            new User("13812345679", "Abc123", "110101199001011234")
    };
    public static int userCount = 0;

    // UI组件
    private JTextField phoneField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    public LogIn() {
        initUI();
        setTitle("用户登录");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initUI() {
        // 设置浅灰色背景
        getContentPane().setBackground(new Color(240, 240, 240));
        setLayout(null);

        // 标题 - 黄色字体，居中显示
        JLabel titleLabel = new JLabel("用户登录", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
        titleLabel.setForeground(Color.YELLOW);
        titleLabel.setBounds(0, 30, 400, 30);
        add(titleLabel);

        // 手机号输入 - 标签右对齐
        JLabel phoneLabel = new JLabel("手机号：", SwingConstants.RIGHT);
        phoneLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        phoneLabel.setBounds(50, 80, 100, 25);
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        phoneField.setBounds(160, 80, 160, 25);
        add(phoneField);

        // 密码输入 - 标签右对齐
        JLabel passwordLabel = new JLabel("密码：", SwingConstants.RIGHT);
        passwordLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        passwordLabel.setBounds(50, 120, 100, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        passwordField.setBounds(160, 120, 160, 25);
        add(passwordField);

        // 登录按钮 - 文本居中
        loginButton = new JButton("登入");
        loginButton.setHorizontalAlignment(SwingConstants.CENTER); // 按钮文本居中
        loginButton.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        loginButton.setBackground(Color.WHITE);
        loginButton.setBounds(100, 170, 80, 30);
        loginButton.addActionListener(this::handleLogin);
        add(loginButton);

        // 注册按钮 - 文本居中
        registerButton = new JButton("注册");
        registerButton.setHorizontalAlignment(SwingConstants.CENTER); // 按钮文本居中
        registerButton.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        registerButton.setBackground(Color.WHITE);
        registerButton.setBounds(220, 170, 80, 30);
        registerButton.addActionListener(this::handleRegister);
        add(registerButton);
    }

    // 其他方法保持不变...
    private void handleLogin(ActionEvent e) {
        String phone = phoneField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (phone.isEmpty() || password.isEmpty()) {
            showError("手机号和密码不能为空");
            return;
        }

        if (phone.length() != 11) {
            showError("手机号必须为11位");
            return;
        }

        User user = findUserByPhone(phone);
        if (user == null) {
            showError("该手机号未注册");
            return;
        }

        if (!user.getPassword().equals(password)) {
            showError("密码错误");
            return;
        }

        Home.setCurrentUser(user);
        this.dispose();
        new Home().setVisible(true);
    }

    private void handleRegister(ActionEvent e) {
        this.dispose();
        new LogOn().setVisible(true);
    }

    private User findUserByPhone(String phone) {
        for (User user : registeredUsers) {
            if (user.getPhone().equals(phone)) {
                return user;
            }
        }
        return null;
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(
                this,
                message,
                "错误",
                JOptionPane.ERROR_MESSAGE
        );
    }

    public static List<User> getRegisteredUsers() {
        return Arrays.asList(registeredUsers);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LogIn().setVisible(true);
        });
    }
}