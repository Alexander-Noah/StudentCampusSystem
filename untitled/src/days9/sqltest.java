package days9;


import java.sql.Connection;
import java.sql.DriverManager;

public class sqltest {

    public static void main(String[] args) {
        try {
            Class.forName("E:\\java\\JAVA\\IDEAJAVA\\untitled\\lib\\mysql-connector-j-8.3.0.jar");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url="jdbc:mysql://localhost:3306/bookdb";//连接字符串
        String user="root";//用户名
        String password="root";//密码，没有为null
        try {
            Connection connection = DriverManager.getConnection(url,user,password);
            //创建sql语句
            String sql = "select * from book";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}