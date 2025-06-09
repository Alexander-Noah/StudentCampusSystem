import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class DeviceManager {
    static Scanner scanner = new Scanner(System.in);
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static void addDevice() throws Exception {
        System.out.println("请输入设备编号：");
        String code = scanner.next();
        System.out.println("请输入设备名称：");
        String name = scanner.next();
        System.out.println("请输入生产日期（yyyy-MM-dd）：");
        String dateStr = scanner.next();
        System.out.println("请输入采购价格：");
        double price = scanner.nextDouble();

        Date date = sdf.parse(dateStr);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        Connection conn = DBUtils.getConnection();
        String sql = "INSERT INTO device(code, name, production_date, price) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, code);
        ps.setString(2, name);
        ps.setDate(3, sqlDate);
        ps.setDouble(4, price);
        ps.executeUpdate();

        DBUtils.close(conn, ps, null);
        System.out.println("*************新增成功********************");
    }

    public static void listDevices() throws Exception {
        Connection conn = DBUtils.getConnection();
        String sql = "SELECT * FROM device";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("序号\t设备编号\t设备名称\t生产日期\t采购价格");
        int i = 1;
        while (rs.next()) {
            System.out.printf("%d\t%s\t%s\t%s\t%.2f\n", i++, rs.getString("code"), rs.getString("name"),
                    rs.getDate("production_date").toString(), rs.getDouble("price"));
        }
        DBUtils.close(conn, stmt, rs);
    }

    public static void modifyDevice() throws Exception {
        listDevices();
        System.out.println("请输入要修改的设备序号（从1开始）：");
        int id = scanner.nextInt();

        System.out.println("请输入要修改的字段编号（1:设备编号 2:设备名称 3:生产日期 4:采购价格）：");
        int field = scanner.nextInt();

        String[] fields = {"code", "name", "production_date", "price"};
        String fieldName = fields[field - 1];

        System.out.println("请输入新的值：");
        String newValue = scanner.next();

        String sql;
        if (fieldName.equals("production_date")) {
            Date date = sdf.parse(newValue);
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            sql = "UPDATE device SET " + fieldName + "=? WHERE id=?";
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, sqlDate);
            ps.setInt(2, id);
            ps.executeUpdate();
            DBUtils.close(conn, ps, null);
        } else if (fieldName.equals("price")) {
            sql = "UPDATE device SET " + fieldName + "=? WHERE id=?";
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, Double.parseDouble(newValue));
            ps.setInt(2, id);
            ps.executeUpdate();
            DBUtils.close(conn, ps, null);
        } else {
            sql = "UPDATE device SET " + fieldName + "=? WHERE id=?";
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, newValue);
            ps.setInt(2, id);
            ps.executeUpdate();
            DBUtils.close(conn, ps, null);
        }

        System.out.println("***************修改成功*********************");
    }

    public static void deleteDevice() throws Exception {
        listDevices();
        System.out.println("请输入要删除的设备序号（从1开始）：");
        int id = scanner.nextInt();
        System.out.println("确定要删除此设备吗？（Y/N）");
        String confirm = scanner.next();

        if (confirm.equalsIgnoreCase("Y")) {
            Connection conn = DBUtils.getConnection();
            String sql = "DELETE FROM device WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            DBUtils.close(conn, ps, null);
            System.out.println("*************删除成功************************");
        }
    }

    public static void searchByName() throws Exception {
        System.out.println("请输入要查询的设备名称（支持模糊查询）：");
        String name = scanner.next();

        Connection conn = DBUtils.getConnection();
        String sql = "SELECT * FROM device WHERE name LIKE ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "%" + name + "%");

        ResultSet rs = ps.executeQuery();
        System.out.println("序号\t设备编号\t设备名称\t生产日期\t采购价格");
        int i = 1;
        boolean hasResult = false;
        while (rs.next()) {
            hasResult = true;
            System.out.printf("%d\t%s\t%s\t%s\t%.2f\n", i++, rs.getString("code"), rs.getString("name"),
                    rs.getDate("production_date").toString(), rs.getDouble("price"));
        }
        if (!hasResult) {
            System.out.println("无符合条件的设备信息");
        }

        DBUtils.close(conn, ps, rs);
    }
}