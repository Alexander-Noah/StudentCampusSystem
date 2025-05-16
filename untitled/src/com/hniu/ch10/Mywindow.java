/*
 * Created by JFormDesigner on Tue Apr 15 21:35:23 CST 2025
 */

package com.hniu.ch10;

import java.awt.*;
import javax.swing.*;

/**
 * @author zheng
 */
public class Mywindow extends JFrame {
    public Mywindow() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- textField1 ----
        textField1.setText("\u767b\u5165");
        contentPane.add(textField1);
        textField1.setBounds(new Rectangle(new Point(95, 25), textField1.getPreferredSize()));

        //---- textField2 ----
        textField2.setText("\u6570\u636e");
        contentPane.add(textField2);
        textField2.setBounds(new Rectangle(new Point(25, 95), textField2.getPreferredSize()));

        //---- textField3 ----
        textField3.setText("\u624b\u673a");
        contentPane.add(textField3);
        textField3.setBounds(new Rectangle(new Point(35, 170), textField3.getPreferredSize()));

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
