package 计算器;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Number extends JFrame {
    // 状态管理变量
    private String currentInput = "";
    private double firstNumber = 0;
    private String currentOperator = "";
    private boolean isNewInput = true;
    private boolean hasDecimalPoint = false;

    // 组件变量
    private JTextField textField1; // 改为JTextField
    private JButton button1, button2, button3, button4, button5, button6,
            button7, button8, button9, button10, button11, button12,
            button13, button14, button15, button17, button18, button19, button20;

    public Number() {
        initComponents();
        initEventListeners();
    }

    private void initComponents() {
        // 初始化所有组件
        textField1 = new JTextField();
        button1 = new JButton("7");
        button2 = new JButton("8");
        button3 = new JButton("9");
        button4 = new JButton("-");
        button5 = new JButton("4");
        button6 = new JButton("1");
        button7 = new JButton("%");
        button8 = new JButton("5");
        button9 = new JButton("2");
        button10 = new JButton("0");
        button11 = new JButton("6");
        button12 = new JButton("3");
        button13 = new JButton(".");
        button14 = new JButton("+");
        button15 = new JButton("=");
        button17 = new JButton("C");
        button18 = new JButton("/");
        button19 = new JButton("*");
        button20 = new JButton("D");

        // 窗口设置
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("计算器");
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======= 输入框设置 ========
        textField1.setEditable(false);
        textField1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
        textField1.setHorizontalAlignment(JTextField.RIGHT); // 右对齐
        contentPane.add(textField1);
        textField1.setBounds(10, 5, 380, 50);

        // 按钮布局（保持原有绝对定位）
        button1.setBounds(17, 114, 70, 32);
        button2.setBounds(120, 114, 70, 32);
        button3.setBounds(212, 115, 70, 32);
        button4.setBounds(300, 114, 70, 32);
        button5.setBounds(15, 164, 70, 32);
        button6.setBounds(15, 219, 70, 32);
        button7.setBounds(15, 272, 70, 32);
        button8.setBounds(120, 163, 70, 32);
        button9.setBounds(121, 219, 70, 32);
        button10.setBounds(120, 271, 70, 32);
        button11.setBounds(210, 164, 70, 32);
        button12.setBounds(215, 219, 70, 32);
        button13.setBounds(216, 272, 70, 32);
        button14.setBounds(301, 162, 70, 32);
        button15.setBounds(303, 211, 70, 95);
        button17.setBounds(15, 71, 70, 32);
        button18.setBounds(120, 71, 70, 32);
        button19.setBounds(210, 71, 70, 32);
        button20.setBounds(300, 71, 70, 32);

        // 统一设置按钮字体
        Font btnFont = new Font("Microsoft YaHei UI", Font.PLAIN, 16);
        Component[] components = {button1, button2, button3, button4, button5, button6,
                button7, button8, button9, button10, button11, button12,
                button13, button14, button15, button17, button18, button19, button20};
        for (Component btn : components) {
            ((JButton) btn).setFont(btnFont);
            contentPane.add((JButton) btn);
        }

        setSize(400, 365);
        setLocationRelativeTo(null);
    }

    private void initEventListeners() {
        // 数字按钮
        button1.addActionListener(e -> appendNumber("7"));
        button2.addActionListener(e -> appendNumber("8"));
        button3.addActionListener(e -> appendNumber("9"));
        button5.addActionListener(e -> appendNumber("4"));
        button8.addActionListener(e -> appendNumber("5"));
        button11.addActionListener(e -> appendNumber("6"));
        button6.addActionListener(e -> appendNumber("1"));
        button9.addActionListener(e -> appendNumber("2"));
        button12.addActionListener(e -> appendNumber("3"));
        button10.addActionListener(e -> appendNumber("0"));

        // 功能按钮
        button13.addActionListener(e -> addDecimalPoint());
        button17.addActionListener(e -> clearAll());
        button20.addActionListener(e -> backspace());
        button7.addActionListener(e -> handlePercentage());

        // 运算符
        button4.addActionListener(e -> setOperator("-"));
        button14.addActionListener(e -> setOperator("+"));
        button18.addActionListener(e -> setOperator("/"));
        button19.addActionListener(e -> setOperator("*"));

        // 等于号
        button15.addActionListener(e -> calculateResult());
    }

    private void appendNumber(String number) {
        if (isNewInput) {
            currentInput = "";
            isNewInput = false;
            hasDecimalPoint = false;
        }
        currentInput += number;
        updateDisplay();
    }

    private void addDecimalPoint() {
        if (!hasDecimalPoint) {
            currentInput = currentInput.isEmpty() ? "0." : currentInput + ".";
            hasDecimalPoint = true;
            isNewInput = false;
            updateDisplay();
        }
    }

    private void updateDisplay() {
        textField1.setText(currentInput.isEmpty() ? "0" : currentInput);
        textField1.setCaretPosition(textField1.getText().length()); // 光标始终在末尾
    }

    private void clearAll() {
        currentInput = "";
        firstNumber = 0;
        currentOperator = "";
        isNewInput = true;
        hasDecimalPoint = false;
        updateDisplay();
    }

    private void backspace() {
        if (!currentInput.isEmpty()) {
            if (currentInput.charAt(currentInput.length() - 1) == '.') {
                hasDecimalPoint = false;
            }
            currentInput = currentInput.substring(0, currentInput.length() - 1);
            updateDisplay();
        }
    }

    private void setOperator(String operator) {
        if (!currentInput.isEmpty()) {
            firstNumber = Double.parseDouble(currentInput);
            currentOperator = operator;
            isNewInput = true;
            hasDecimalPoint = false;
        }
    }

    private void handlePercentage() {
        if (!currentInput.isEmpty()) {
            try {
                double value = Double.parseDouble(currentInput) / 100;
                currentInput = value % 1 == 0 ?
                        String.valueOf((int) value) :
                        String.valueOf(value);
                hasDecimalPoint = currentInput.contains(".");
                updateDisplay();
            } catch (NumberFormatException ex) {
                currentInput = "错误";
                updateDisplay();
            }
        }
    }

    private void calculateResult() {
        if (!currentOperator.isEmpty() && !currentInput.isEmpty()) {
            try {
                double secondNumber = Double.parseDouble(currentInput);
                double result = switch (currentOperator) {
                    case "+" -> firstNumber + secondNumber;
                    case "-" -> firstNumber - secondNumber;
                    case "*" -> firstNumber * secondNumber;
                    case "/" -> {
                        if (secondNumber == 0) throw new ArithmeticException();
                        yield firstNumber / secondNumber;
                    }
                    default -> 0;
                };

                currentInput = result % 1 == 0 ?
                        String.valueOf((int) result) :
                        String.valueOf(result);
                hasDecimalPoint = currentInput.contains(".");
            } catch (ArithmeticException ex) {
                currentInput = "错误";
            } finally {
                currentOperator = "";
                isNewInput = true;
                updateDisplay();
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new Number().setVisible(true));
    }
}