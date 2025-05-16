/**
 * 用户实体类
 * 封装用户的基本信息，包括手机号、密码和身份证号
 */
public class User {
    // 用户属性
    private String phone;    // 手机号（11位数字）
    private String password; // 登录密码
    private String idCard;   // 身份证号（18位）

    /**
     * 构造函数
     * @param phone 手机号（必须为11位数字）
     * @param password 登录密码（建议包含大小写字母和数字）
     * @param idCard 身份证号（必须为18位）
     */
    public User(String phone, String password, String idCard) {
        this.phone = phone;
        this.password = password;
        this.idCard = idCard;
    }

    /**
     * 获取手机号
     * @return 手机号字符串
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 获取登录密码
     * @return 密码字符串
     */
    public String getPassword() {
        return password;
    }

    /**
     * 获取身份证号
     * @return 身份证号字符串
     */
    public String getIdCard() {
        return idCard;
    }

    // 注意：根据业务需求，这里没有提供setter方法
    // 因为用户信息一旦创建后不应被随意修改
    // 如果需要修改用户信息，应该通过专门的更新方法或新建对象实现
}