import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class DeviceManager {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public void addDevice() {
        try {
            System.out.print("请输入设备编号：");
            String no = scanner.next();
            System.out.print("请输入设备名称：");
            String name = scanner.next();
            System.out.print("请输入生产日期（yyyy-MM-dd）：");
            String dateStr = scanner.next();
            System.out.print("请输入采购价格：");
            double price = scanner.nextDouble();

            if (!isValidDate(dateStr)) {
                System.out.println("无效的日期格式，请输入正确的日期格式（yyyy-MM-dd）");
                return;
            }

            Date date = sdf.parse(dateStr);
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            Connection conn = DBUtils.getConnection();
            String sql = "INSERT INTO devices (device_no, name, production_date, price) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, no);
            stmt.setString(2, name);
            stmt.setDate(3, sqlDate);
            stmt.setDouble(4, price);
            stmt.executeUpdate();

            DBUtils.close(conn, stmt);
            System.out.println("*************新增成功********************");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateDevice() {
        List<Device> list = getAllDevices();
        if (list.isEmpty()) return;

        System.out.print("请输入要修改的设备序号：");
        int index = scanner.nextInt();

        if (index < 1 || index > list.size()) {
            System.out.println("无效的设备序号，请输入有效的序号。");
            return;
        }

        Device d = list.get(index - 1);
        System.out.println("1: 设备编号  2: 设备名称  3: 生产日期  4: 采购价格");
        System.out.print("请输入要修改的字段编号：");
        int field = scanner.nextInt();

        if (field < 1 || field > 4) {
            System.out.println("无效的字段编号，请输入1到4之间的数字。");
            return;
        }

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement stmt = null;
            switch (field) {
                case 1:
                    System.out.print("新设备编号：");
                    String no = scanner.next();
                    stmt = conn.prepareStatement("UPDATE devices SET device_no=? WHERE id=?");
                    stmt.setString(1, no);
                    stmt.setInt(2, d.getId());
                    break;
                case 2:
                    System.out.print("新设备名称：");
                    String name = scanner.next();
                    stmt = conn.prepareStatement("UPDATE devices SET name=? WHERE id=?");
                    stmt.setString(1, name);
                    stmt.setInt(2, d.getId());
                    break;
                case 3:
                    System.out.print("新生产日期（yyyy-MM-dd）：");
                    String dateStr = scanner.next();
                    if (!isValidDate(dateStr)) {
                        System.out.println("无效的日期格式，请输入正确的日期格式（yyyy-MM-dd）");
                        return;
                    }
                    Date date = sdf.parse(dateStr);
                    stmt = conn.prepareStatement("UPDATE devices SET production_date=? WHERE id=?");
                    stmt.setDate(1, new java.sql.Date(date.getTime()));
                    stmt.setInt(2, d.getId());
                    break;
                case 4:
                    System.out.print("新采购价格：");
                    double price = scanner.nextDouble();
                    stmt = conn.prepareStatement("UPDATE devices SET price=? WHERE id=?");
                    stmt.setDouble(1, price);
                    stmt.setInt(2, d.getId());
                    break;
            }
            stmt.executeUpdate();
            DBUtils.close(conn, stmt);
            System.out.println("***************修改成功*********************");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteDevice() {
        List<Device> list = getAllDevices();
        if (list.isEmpty()) return;

        System.out.print("请输入要删除的设备序号：");
        int index = scanner.nextInt();

        if (index < 1 || index > list.size()) {
            System.out.println("无效的设备序号，请输入有效的序号。");
            return;
        }

        Device d = list.get(index - 1);
        System.out.print("确定要删除此设备吗？（Y/N）：");
        String confirm = scanner.next();

        if (!confirm.equalsIgnoreCase("Y") && !confirm.equalsIgnoreCase("N")) {
            System.out.println("无效的确认输入，请输入Y或N。");
            return;
        }

        if ("Y".equalsIgnoreCase(confirm)) {
            try {
                Connection conn = DBUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM devices WHERE id=?");
                stmt.setInt(1, d.getId());
                stmt.executeUpdate();
                DBUtils.close(conn, stmt);
                System.out.println("*************删除成功************************");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void queryAllDevices() {
        getAllDevices();
    }

    public void queryByName() {
        System.out.print("请输入要查询的设备名称：");
        String keyword = scanner.next();
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM devices WHERE name LIKE ?");
            stmt.setString(1, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();
            printDevices(rs);
            DBUtils.close(conn, stmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Device> getAllDevices() {
        List<Device> list = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM devices");
            list = printDevices(rs);
            DBUtils.close(conn, stmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private List<Device> printDevices(ResultSet rs) throws SQLException {
        List<Device> list = new ArrayList<>();
        int i = 1;
        System.out.printf("%-5s %-10s %-10s %-15s %-10s\n", "序号", "设备编号", "设备名称", "生产日期", "采购价格");
        while (rs.next()) {
            Device d = new Device();
            d.setId(rs.getInt("id"));
            d.setDeviceNo(rs.getString("device_no"));
            d.setName(rs.getString("name"));
            d.setProductionDate(rs.getDate("production_date"));
            d.setPrice(rs.getDouble("price"));
            list.add(d);
            System.out.printf("%-5d %-10s %-10s %-15s %-10.2f\n", i++, d.getDeviceNo(), d.getName(), d.getProductionDate(), d.getPrice());
        }
        if (list.isEmpty()) {
            System.out.println("无符合条件的设备信息");
        }
        return list;
    }

    private boolean isValidDate(String dateStr) {
        try {
            sdf.setLenient(false);
            sdf.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}