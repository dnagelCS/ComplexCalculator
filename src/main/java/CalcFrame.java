import javax.swing.*;
import java.awt.*;

public class CalcFrame extends JFrame {
    Complex complex;

    private JPanel tvs;
    private JTextField complex1;
    private JTextField operator;
    private JTextField complex2;

    private JPanel buttonPanel;
    private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    private JButton decimal;
    private JButton clear;
    private JButton add, subtract, multiply, divide;

    private JButton equals;

    public CalcFrame() {
        setSize(300,250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Complex Calculator");
        setLayout(new BorderLayout());

        complex1 = new JTextField(10);
        complex1.setBackground(Color.WHITE);
        complex1.setEditable(false);

        operator = new JTextField(4);
        operator.setBackground(Color.WHITE);
        operator.setEditable(false);

        complex2 = new JTextField(10);
        complex2.setBackground(Color.WHITE);
        complex2.setEditable(false);

        tvs = new JPanel();
        tvs.add(complex1);
        tvs.add(operator);
        tvs.add(complex2);

        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");

        decimal = new JButton(".");
        clear = new JButton("C");

        add = new JButton("+");
        subtract = new JButton("-");
        multiply = new JButton("*");
        divide = new JButton("/");

        buttonPanel = new JPanel(new GridLayout(4,4,2,2));
        buttonPanel.add(add);
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
        buttonPanel.add(subtract);
        buttonPanel.add(b4);
        buttonPanel.add(b5);
        buttonPanel.add(b6);
        buttonPanel.add(multiply);
        buttonPanel.add(b7);
        buttonPanel.add(b8);
        buttonPanel.add(b9);
        buttonPanel.add(divide);
        buttonPanel.add(decimal);
        buttonPanel.add(b0);
        buttonPanel.add(clear);

        equals = new JButton("=");

        add(tvs, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        //add(operatorsPanel, BorderLayout.WEST);
        add(equals, BorderLayout.SOUTH);
    }
}
