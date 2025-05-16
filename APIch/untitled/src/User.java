public class User {
    private String phone;
    private String password;
    private String idCard;

    public User(String phone, String password, String idCard) {
        this.phone = phone;
        this.password = password;
        this.idCard = idCard;
    }

    // Getter方法
    public String getPhone() { return phone; }
    public String getPassword() { return password; }
    public String getIdCard() { return idCard; }
}