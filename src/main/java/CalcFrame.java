import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class CalcFrame extends JFrame {
    Complex complex = new Complex();

    private JLabel prompt;
    private JPanel gridPanel;
    private JLabel complex1;
    private JTextField complex1TF;
    private DefaultListCellRenderer listRenderer;
    private JComboBox operatorChoices;
    private String[] operators = {"Add", "Subtract", "Multiply", "Divide"};
    private JLabel complex2;
    private JTextField complex2TF;
    private JButton equals;

    private JTextField output;

    public CalcFrame() {
        //TODO: update UI
        setSize(500, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Complex Calculator");
        setLayout(new BorderLayout());

        initUI();

        add(prompt, BorderLayout.NORTH);
        add(gridPanel, BorderLayout.CENTER);
        add(output, BorderLayout.SOUTH);
    }

    private void initUI() {
        prompt = new JLabel("Set both complex numbers in the format (a + bi) and select the operation choice:");
        prompt.setHorizontalAlignment(JLabel.CENTER);
        complex1 = new JLabel("Complex 1:");
        complex1.setHorizontalAlignment(JLabel.CENTER);
        complex1TF = new JTextField();
        operatorChoices = new JComboBox(operators);
        operatorChoices.setEditable(false);
        listRenderer = new DefaultListCellRenderer();
        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        operatorChoices.setRenderer(listRenderer);
        operatorChoices.addActionListener(actionEvent -> setOp());
        complex2 = new JLabel("Complex 2:");
        complex2.setHorizontalAlignment(JLabel.CENTER);
        complex2TF = new JTextField();
        equals = new JButton("=");
        equals.addActionListener(actionEvent -> calcResult());
        gridPanel = new JPanel(new GridLayout(2,3, 4,4));
        gridPanel.add(complex1);
        gridPanel.add(complex2);
        gridPanel.add(operatorChoices);
        gridPanel.add(complex1TF);
        gridPanel.add(complex2TF);
        gridPanel.add(equals);

        output = new JTextField("Output:");
        output.setEditable(false);
        output.setColumns(16);
    }

    private void setOp() {
        String choice = (String) operatorChoices.getSelectedItem();
        if(choice.equals("Add")) {
            complex.setChoice("+");
        } else if (choice.equals("Subtract")) {
            complex.setChoice("-");
        } else if (choice.equals("Multiply")) {
            complex.setChoice("*");
        } else {
            complex.setChoice("/");
        }
    }

    private void calcResult() {
        //TODO: fix number retrieval (negative numbers) and case for plain i
        //TODO: add error case
        double a, b, c, d;
        if(!complex1TF.getText().contains("(") || !complex1TF.getText().contains(")") || !complex2TF.getText().contains("(")
        || !complex2TF.getText().contains(")") || complex1TF.getText().isEmpty() || complex2TF.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ERROR:\nMake sure the complex number is in the format (a + bi)");
        } else {
            a = Double.parseDouble(complex1TF.getText().substring(complex1TF.getText().lastIndexOf("(") + 1));
            b = Double.parseDouble(complex1TF.getText().substring(complex1TF.getText().lastIndexOf(")") - 2));
            c = Double.parseDouble(complex2TF.getText().substring(complex2TF.getText().lastIndexOf("(") + 1));
            d = Double.parseDouble(complex2TF.getText().substring(complex2TF.getText().lastIndexOf(")") - 2));

            double[] comp1 = {a, b};
            double[] comp2 = {c, d};
            double[] result;
            result = complex.binOp(comp1, comp2);
            String res = Arrays.toString(result).replace("[", "").replace("]", "");
            if (result[1] != 0) {
                output.setText("Output: " + res + "i");
            } else {
                output.setText("Output: " + res);
            }
        }
    }
}
