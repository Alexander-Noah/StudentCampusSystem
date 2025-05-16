import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 用户信息展示界面类
 * 显示当前登录用户的基本信息，包括手机号、身份证号、出生年月和性别
 */
public class Home extends JFrame {
    // 当前登录用户
    private static User currentUser;

    // UI组件声明
    private JLabel phoneLabel;     // 手机号显示标签
    private JLabel idCardLabel;    // 身份证号显示标签
    private JLabel birthdayLabel;  // 出生年月显示标签
    private JLabel genderLabel;    // 性别显示标签
    private JButton logoutButton;  // 注销按钮

    /**
     * 构造函数
     */
    public Home() {
        initUI();  // 初始化用户界面
        setTitle("用户信息");  // 设置窗口标题
        setSize(450, 350);    // 设置窗口大小
        setLocationRelativeTo(null);  // 窗口居中显示
        setResizable(false);          // 禁止调整窗口大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 关闭窗口时退出程序
        displayUserInfo();  // 显示用户信息
    }

    /**
     * 初始化用户界面
     */
    private void initUI() {
        // 设置窗口背景色为浅灰色
        getContentPane().setBackground(new Color(240, 240, 240));
        setLayout(null); // 使用绝对布局（null layout）

        /* 标题标签 */
        JLabel titleLabel = new JLabel("用户信息", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 24)); // 设置字体
        titleLabel.setForeground(Color.YELLOW); // 设置文字颜色为黄色
        titleLabel.setBounds(0, 30, 450, 30);  // 设置位置和大小
        add(titleLabel);  // 添加到窗口

        // 统一的标签宽度和右对齐设置
        int labelWidth = 100;     // 标签统一宽度
        int contentX = 160;       // 内容显示起始X坐标

        /* 手机号信息部分 */
        // 手机号标签（右对齐）
        JLabel phoneTitle = new JLabel("手机号：", SwingConstants.RIGHT);
        phoneTitle.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));
        phoneTitle.setBounds(50, 80, labelWidth, 25);
        add(phoneTitle);

        // 手机号显示内容（左对齐）
        phoneLabel = new JLabel("", SwingConstants.LEFT);
        phoneLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));
        phoneLabel.setBounds(contentX, 80, 240, 25);
        add(phoneLabel);

        /* 身份证号信息部分 */
        // 身份证号标签（右对齐）
        JLabel idCardTitle = new JLabel("身份证号：", SwingConstants.RIGHT);
        idCardTitle.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));
        idCardTitle.setBounds(50, 120, labelWidth, 25);
        add(idCardTitle);

        // 身份证号显示内容（左对齐）
        idCardLabel = new JLabel("", SwingConstants.LEFT);
        idCardLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));
        idCardLabel.setBounds(contentX, 120, 240, 25);
        add(idCardLabel);

        /* 出生年月信息部分 */
        // 出生年月标签（右对齐）
        JLabel birthdayTitle = new JLabel("出生年月：", SwingConstants.RIGHT);
        birthdayTitle.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));
        birthdayTitle.setBounds(50, 160, labelWidth, 25);
        add(birthdayTitle);

        // 出生年月显示内容（左对齐）
        birthdayLabel = new JLabel("", SwingConstants.LEFT);
        birthdayLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));
        birthdayLabel.setBounds(contentX, 160, 240, 25);
        add(birthdayLabel);

        /* 性别信息部分 */
        // 性别标签（右对齐）
        JLabel genderTitle = new JLabel("性别：", SwingConstants.RIGHT);
        genderTitle.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));
        genderTitle.setBounds(50, 200, labelWidth, 25);
        add(genderTitle);

        // 性别显示内容（左对齐）
        genderLabel = new JLabel("", SwingConstants.LEFT);
        genderLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));
        genderLabel.setBounds(contentX, 200, 240, 25);
        add(genderLabel);

        /* 注销按钮 */
        logoutButton = new JButton("注销");
        logoutButton.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        logoutButton.setBackground(Color.WHITE);  // 白色背景
        logoutButton.setBounds(175, 250, 100, 30); // 居中显示
        logoutButton.addActionListener(e -> logout()); // 添加点击事件监听
        add(logoutButton);
    }

    /**
     * 显示用户信息
     */
    private void displayUserInfo() {
        if (currentUser != null) {
            // 设置脱敏后的手机号（显示前3位和后4位）
            phoneLabel.setText(maskInfo(currentUser.getPhone(), 3, 4));
            // 设置脱敏后的身份证号（显示前3位和后4位）
            idCardLabel.setText(maskInfo(currentUser.getIdCard(), 3, 4));
            // 设置格式化后的出生年月
            birthdayLabel.setText(formatBirthday(currentUser.getIdCard()));
            // 设置从身份证解析出的性别
            genderLabel.setText(getGenderFromIdCard(currentUser.getIdCard()));
        }
    }

    /**
     * 信息脱敏处理
     * @param info 原始信息
     * @param prefixLen 保留前几位
     * @param suffixLen 保留后几位
     * @return 脱敏后的信息（如：138****1234）
     */
    private String maskInfo(String info, int prefixLen, int suffixLen) {
        if (info == null || info.length() <= prefixLen + suffixLen) {
            return info; // 长度不足时返回原信息
        }
        String prefix = info.substring(0, prefixLen); // 获取前几位
        String suffix = info.substring(info.length() - suffixLen); // 获取后几位
        return prefix + "****" + suffix; // 拼接脱敏结果
    }

    /**
     * 格式化生日显示（从身份证号提取）
     * @param idCard 身份证号
     * @return 格式化后的生日（如：1990年03月）
     */
    private String formatBirthday(String idCard) {
        if (idCard == null || idCard.length() < 14) {
            return "未知"; // 身份证号无效时返回"未知"
        }
        // 提取年月信息（身份证第7-14位）
        return idCard.substring(6, 10) + "年" + idCard.substring(10, 12) + "月";
    }

    /**
     * 从身份证号获取性别
     * @param idCard 身份证号
     * @return "男"或"女"
     */
    private String getGenderFromIdCard(String idCard) {
        if (idCard == null || idCard.length() < 17) {
            return "未知"; // 身份证号无效时返回"未知"
        }
        // 根据身份证第17位判断性别（奇数为男，偶数为女）
        return (idCard.charAt(16) % 2 == 1) ? "男" : "女";
    }

    /**
     * 注销登录
     */
    private void logout() {
        currentUser = null; // 清空当前用户
        dispose();         // 关闭当前窗口
        new LogIn().setVisible(true); // 打开登录窗口
    }

    /**
     * 设置当前登录用户
     * @param user 用户对象
     */
    public static void setCurrentUser(User user) {
        currentUser = user;
    }
}