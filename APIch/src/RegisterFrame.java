import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Tue Apr 22 19:35:32 CST 2025
 */



/**
 * @author zheng
 */
public class RegisterFrame extends JFrame {
    public RegisterFrame() {
        initComponents();
    }

    private void textField1(ActionEvent e) {
        // TODO add your code here
    }

    private void shabmit(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        textField4 = new JTextField();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        passwordField1 = new JPasswordField();
        passwordField2 = new JPasswordField();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u624b\u673a\u53f7");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(85, 75), label1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(155, 67, 315, 30);

        //---- label2 ----
        label2.setText("\u8eab\u4efd\u8bc1");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(85, 125), label2.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(155, 119, 315, 30);

        //---- label3 ----
        label3.setText("\u90ae\u7bb1");
        contentPane.add(label3);
        label3.setBounds(85, 185, 36, 17);
        contentPane.add(textField3);
        textField3.setBounds(157, 175, 315, 30);

        //---- label4 ----
        label4.setText("\u4e3b\u9875");
        contentPane.add(label4);
        label4.setBounds(80, 245, 36, 17);
        contentPane.add(textField4);
        textField4.setBounds(155, 245, 315, 30);

        //---- label5 ----
        label5.setText("\u5bc6\u7801");
        contentPane.add(label5);
        label5.setBounds(85, 320, 36, 17);

        //---- label6 ----
        label6.setText("\u4e3b\u9875");
        contentPane.add(label6);
        label6.setBounds(0, 400, 36, 0);

        //---- label7 ----
        label7.setText("\u786e\u8ba4\u5bc6\u7801");
        contentPane.add(label7);
        label7.setBounds(55, 375, 80, 20);
        contentPane.add(passwordField1);
        passwordField1.setBounds(160, 310, 310, passwordField1.getPreferredSize().height);
        contentPane.add(passwordField2);
        passwordField2.setBounds(155, 375, 300, passwordField2.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u63d0\u4ea4");
        button1.addActionListener(e -> shabmit(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(240, 460), button1.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(930, 630));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label4;
    private JTextField textField4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
