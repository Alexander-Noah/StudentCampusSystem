import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame {
    private static User currentUser;

    // UI组件
    private JLabel phoneLabel;
    private JLabel idCardLabel;
    private JLabel birthdayLabel;
    private JLabel genderLabel;
    private JButton logoutButton;

    public Home() {
        initUI();
        setTitle("用户信息");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        displayUserInfo();
    }

    private void initUI() {
        // 设置浅灰色背景
        getContentPane().setBackground(new Color(240, 240, 240));
        setLayout(null);

        // 标题 - 黄色字体，居中显示
        JLabel titleLabel = new JLabel("用户信息", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
        titleLabel.setForeground(Color.YELLOW);
        titleLabel.setBounds(0, 30, 450, 30);
        add(titleLabel);

        // 统一的标签宽度和右对齐
        int labelWidth = 100;
        int contentX = 160; // 内容起始位置

        // 手机号信息 - 标签右对齐
        JLabel phoneTitle = new JLabel("手机号：", SwingConstants.RIGHT);
        phoneTitle.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));
        phoneTitle.setBounds(50, 80, labelWidth, 25);
        add(phoneTitle);

        phoneLabel = new JLabel("", SwingConstants.LEFT);
        phoneLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));
        phoneLabel.setBounds(contentX, 80, 240, 25);
        add(phoneLabel);

        // 身份证号信息 - 标签右对齐
        JLabel idCardTitle = new JLabel("身份证号：", SwingConstants.RIGHT);
        idCardTitle.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));
        idCardTitle.setBounds(50, 120, labelWidth, 25);
        add(idCardTitle);

        idCardLabel = new JLabel("", SwingConstants.LEFT);
        idCardLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));
        idCardLabel.setBounds(contentX, 120, 240, 25);
        add(idCardLabel);

        // 出生年月信息 - 标签右对齐
        JLabel birthdayTitle = new JLabel("出生年月：", SwingConstants.RIGHT);
        birthdayTitle.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));
        birthdayTitle.setBounds(50, 160, labelWidth, 25);
        add(birthdayTitle);

        birthdayLabel = new JLabel("", SwingConstants.LEFT);
        birthdayLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));
        birthdayLabel.setBounds(contentX, 160, 240, 25);
        add(birthdayLabel);

        // 性别信息 - 标签右对齐
        JLabel genderTitle = new JLabel("性别：", SwingConstants.RIGHT);
        genderTitle.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));
        genderTitle.setBounds(50, 200, labelWidth, 25);
        add(genderTitle);

        genderLabel = new JLabel("", SwingConstants.LEFT);
        genderLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));
        genderLabel.setBounds(contentX, 200, 240, 25);
        add(genderLabel);

        // 注销按钮 - 白色背景，居中显示
        logoutButton = new JButton("注销");
        logoutButton.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        logoutButton.setBackground(Color.WHITE);
        logoutButton.setBounds(175, 250, 100, 30);
        logoutButton.addActionListener(e -> logout());
        add(logoutButton);
    }

    private void displayUserInfo() {
        if (currentUser != null) {
            phoneLabel.setText(maskInfo(currentUser.getPhone(), 3, 4));
            idCardLabel.setText(maskInfo(currentUser.getIdCard(), 3, 4));
            birthdayLabel.setText(formatBirthday(currentUser.getIdCard()));
            genderLabel.setText(getGenderFromIdCard(currentUser.getIdCard()));
        }
    }

    // 信息脱敏处理
    private String maskInfo(String info, int prefixLen, int suffixLen) {
        if (info == null || info.length() <= prefixLen + suffixLen) {
            return info;
        }
        String prefix = info.substring(0, prefixLen);
        String suffix = info.substring(info.length() - suffixLen);
        return prefix + "****" + suffix;
    }

    // 格式化生日显示
    private String formatBirthday(String idCard) {
        if (idCard == null || idCard.length() < 14) {
            return "未知";
        }
        return idCard.substring(6, 10) + "年" + idCard.substring(10, 12) + "月";
    }

    // 从身份证获取性别
    private String getGenderFromIdCard(String idCard) {
        if (idCard == null || idCard.length() < 17) {
            return "未知";
        }
        return (idCard.charAt(16) % 2 == 1) ? "男" : "女";
    }

    private void logout() {
        currentUser = null;
        dispose();
        new LogIn().setVisible(true);
    }

    public static void setCurrentUser(User user) {
        currentUser = user;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 测试数据
            Home.setCurrentUser(new User("13812345678", "password", "110101199001011234"));
            new Home().setVisible(true);
        });
    }
}