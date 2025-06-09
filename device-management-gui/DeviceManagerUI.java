import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class DeviceManagerUI extends JFrame {
    private JTextField searchField;
    private JTable table;
    private DefaultTableModel tableModel;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public DeviceManagerUI() {
        setTitle("设备管理系统");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 顶部搜索面板
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchField = new JTextField(20);
        JButton searchBtn = new JButton("查询");
        searchBtn.addActionListener(e -> loadData(searchField.getText().trim()));
        topPanel.add(new JLabel("设备名称："));
        topPanel.add(searchField);
        topPanel.add(searchBtn);

        // 中部表格
        tableModel = new DefaultTableModel(new String[]{"ID", "编号", "名称", "生产日期", "价格"}, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // 底部按钮面板
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton addBtn = new JButton("新增");
        JButton editBtn = new JButton("修改");
        JButton deleteBtn = new JButton("删除");
        bottomPanel.add(addBtn);
        bottomPanel.add(editBtn);
        bottomPanel.add(deleteBtn);

        addBtn.addActionListener(e -> showDeviceDialog(null));
        editBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                Vector rowData = tableModel.getDataVector().elementAt(row);
                showDeviceDialog(rowData);
            } else {
                JOptionPane.showMessageDialog(this, "请选择要修改的设备");
            }
        });
        deleteBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                int id = (int) tableModel.getValueAt(row, 0);
                int res = JOptionPane.showConfirmDialog(this, "确认删除？", "提示", JOptionPane.YES_NO_OPTION);
                if (res == JOptionPane.YES_OPTION) {
                    deleteDevice(id);
                    loadData("");
                }
            } else {
                JOptionPane.showMessageDialog(this, "请选择要删除的设备");
            }
        });

        // 布局
        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);

        loadData("");
    }

    private void loadData(String nameFilter) {
        try {
            Connection conn = DBUtils.getConnection();
            String sql = nameFilter.isEmpty() ?
                    "SELECT * FROM device" :
                    "SELECT * FROM device WHERE name LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            if (!nameFilter.isEmpty()) {
                ps.setString(1, "%" + nameFilter + "%");
            }
            ResultSet rs = ps.executeQuery();
            tableModel.setRowCount(0);
            while (rs.next()) {
                tableModel.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("code"),
                        rs.getString("name"),
                        rs.getDate("production_date"),
                        rs.getDouble("price")
                });
            }
            DBUtils.close(conn, ps, rs);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "加载数据出错：" + ex.getMessage());
        }
    }

    private void showDeviceDialog(Vector rowData) {
        JTextField codeField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField dateField = new JTextField();
        JTextField priceField = new JTextField();

        if (rowData != null) {
            codeField.setText(rowData.get(1).toString());
            nameField.setText(rowData.get(2).toString());
            dateField.setText(rowData.get(3).toString());
            priceField.setText(rowData.get(4).toString());
        }

        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
        panel.add(new JLabel("设备编号：")); panel.add(codeField);
        panel.add(new JLabel("设备名称：")); panel.add(nameField);
        panel.add(new JLabel("生产日期(yyyy-MM-dd)：")); panel.add(dateField);
        panel.add(new JLabel("采购价格：")); panel.add(priceField);

        int option = JOptionPane.showConfirmDialog(this, panel,
                rowData == null ? "新增设备" : "修改设备", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String code = codeField.getText().trim();
            String name = nameField.getText().trim();
            String dateStr = dateField.getText().trim();
            String priceStr = priceField.getText().trim();
            try {
                java.util.Date d = sdf.parse(dateStr);
                java.sql.Date sqlDate = new java.sql.Date(d.getTime());
                double price = Double.parseDouble(priceStr);
                if (rowData == null) {
                    insertDevice(code, name, sqlDate, price);
                } else {
                    int id = (int) rowData.get(0);
                    updateDevice(id, code, name, sqlDate, price);
                }
                loadData("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "操作出错：" + ex.getMessage());
            }
        }
    }

    private void insertDevice(String code, String name, java.sql.Date date, double price) throws Exception {
        Connection conn = DBUtils.getConnection();
        String sql = "INSERT INTO device(code, name, production_date, price) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, code); ps.setString(2, name);
        ps.setDate(3, date); ps.setDouble(4, price);
        ps.executeUpdate();
        DBUtils.close(conn, ps, null);
    }

    private void updateDevice(int id, String code, String name, java.sql.Date date, double price) throws Exception {
        Connection conn = DBUtils.getConnection();
        String sql = "UPDATE device SET code=?, name=?, production_date=?, price=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, code); ps.setString(2, name);
        ps.setDate(3, date); ps.setDouble(4, price);
        ps.setInt(5, id);
        ps.executeUpdate();
        DBUtils.close(conn, ps, null);
    }

    private void deleteDevice(int id) {
        try {
            Connection conn = DBUtils.getConnection();
            String sql = "DELETE FROM device WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            DBUtils.close(conn, ps, null);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "删除出错：" + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DeviceManagerUI().setVisible(true);
        });
    }
}