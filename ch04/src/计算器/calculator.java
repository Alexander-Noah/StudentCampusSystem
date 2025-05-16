/*
 * Created by JFormDesigner on Fri Apr 18 08:36:58 CST 2025
 */

package 计算器;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import net.miginfocom.swing.*;



/**
 * @author zheng
 */
public class calculator extends JFrame {
    public calculator() {
        initComponents();
    }

    private void thisMouseClicked(MouseEvent e) {
        // TODO add your code here
        setVisible(false);
        new Number();
    }

    private void openNumber(ActionEvent e) {
        // TODO add your code here
        Number number= new Number();
        number.setVisible(true);
        this.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        button1 = new JButton();

        //======== this ========
        setBackground(Color.white);
        setForeground(SystemColor.menu);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                thisMouseClicked(e);
            }
        });
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u8ba1\u7b97\u5668\u767b\u5165");
        label1.setForeground(Color.orange);
        label1.setBackground(Color.white);
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));
        contentPane.add(label1);
        label1.setBounds(137, 30, 140, 30);

        //---- button1 ----
        button1.setText("\u767b\u5165");
        button1.setBackground(Color.white);
        button1.setForeground(Color.black);
        button1.addActionListener(e -> openNumber(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(159, 116), button1.getPreferredSize()));

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
        setSize(400, 300);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
