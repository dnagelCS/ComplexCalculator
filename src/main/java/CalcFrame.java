import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

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
    private JButton i;
    private JButton leftParent, rightParent;
    private JButton back;
    private JButton add, subtract, multiply, divide;

    private JButton equals;

    public CalcFrame() {
        //TODO: add actionListeners
        //instead of clear, make it an i button?
        //or see if I can automatically add i at end of user string (i think i can)

        setSize(300, 250);
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
        i = new JButton("i");

        add = new JButton("+");
        subtract = new JButton("-");
        multiply = new JButton("*");
        divide = new JButton("/");
        leftParent = new JButton("(");
        rightParent = new JButton(")");
        back = new JButton("\u2190");
        clear = new JButton("C");

        buttonPanel = new JPanel(new GridLayout(4, 5, 2, 2));
        buttonPanel.add(b7);
        buttonPanel.add(b8);
        buttonPanel.add(b9);
        buttonPanel.add(multiply);
        buttonPanel.add(divide);
        buttonPanel.add(b4);
        buttonPanel.add(b5);
        buttonPanel.add(b6);
        buttonPanel.add(add);
        buttonPanel.add(subtract);
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
        buttonPanel.add(leftParent);
        buttonPanel.add(rightParent);
        buttonPanel.add(b0);
        buttonPanel.add(decimal);
        buttonPanel.add(i);
        buttonPanel.add(back);
        buttonPanel.add(clear);

        equals = new JButton("=");

        add(tvs, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        //add(operatorsPanel, BorderLayout.WEST);
        add(equals, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        String comp1a = "";
        String comp1b = "";
        String comp2a = "";
        String comp2b = "";
        String op = "";
        String str = e.getActionCommand();

        if ((str.charAt(0) >= '0' && str.charAt(0) <= '9') || str.charAt(0) == '.') {
            //if operand is present then add to imaginary num for each complex number
            if (!op.equals("")) {
                comp1b = comp1b + str;
                comp2b = comp2b + str;
            } else {
                comp1a = comp1a + str;
                comp2a = comp2a + str;

                //set the value of text
                complex1.setText(comp1a + op + comp1b);
                complex2.setText(comp2a + op + comp2b);
                //also for operator TV
            }
        } else if (str.charAt(0) == 'C') {
            comp1a = "";
            comp1b = "";
            comp2a = "";
            comp2b = "";
            op = "";

            complex1.setText("");
            operator.setText("");
            complex2.setText("");
        } else if (str.charAt(0) == '=') {

        }

    }
}
