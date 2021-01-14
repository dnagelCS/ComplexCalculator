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
        String[] comp1parts;
        String c1pt1;
        String c1pt2;
        String[] comp2parts;
        String c2pt1;
        String c2pt2;
        double a, b, c, d;
        //if not in correct format, show error message
        if(!complex1TF.getText().contains("(") || !complex1TF.getText().contains(")") || !complex2TF.getText().contains("(")
        || !complex2TF.getText().contains(")") || complex1TF.getText().isEmpty() || complex2TF.getText().isEmpty() ||
        complex1TF.getText().contains("*") || complex1TF.getText().contains("/") || complex2TF.getText().contains("*") ||
        complex2TF.getText().contains("/")) {
            JOptionPane.showMessageDialog(this, "Make sure the complex number is in the format (a + bi)", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            //Complex 1: check whether pos or neg imaginary value
            if (complex1TF.getText().contains("+")) {
                comp1parts = complex1TF.getText().split("\\+");
                c1pt1 = comp1parts[0];
                c1pt2 = comp1parts[1];
                a = Double.parseDouble(c1pt1.substring(c1pt1.lastIndexOf("(") + 1));
                b = getPosImag(c1pt2);
            } else {
                comp1parts = complex1TF.getText().split("-");
                c1pt1 = comp1parts[0];
                c1pt2 = comp1parts[1];
                a = Double.parseDouble(c1pt1.substring(c1pt1.lastIndexOf("(") + 1));
                b = getNegImag(c1pt2);
            }
            //Complex 2: check whether pos or neg imaginary value
            if (complex2TF.getText().contains("+")) {
                comp2parts = complex2TF.getText().split("\\+");
                c2pt1 = comp2parts[0];
                c2pt2 = comp2parts[1];
                c = Double.parseDouble(c2pt1.substring(c2pt1.lastIndexOf("(") + 1));
                d = getPosImag(c2pt2);
            } else {
                comp1parts = complex2TF.getText().split("-");
                c2pt1 = comp1parts[0];
                c2pt2 = comp1parts[1];
                c = Double.parseDouble(c2pt1.substring(c2pt1.lastIndexOf("(") + 1));
                d = getNegImag(c2pt2);
            }

            double[] comp1 = {a, b};
            double[] comp2 = {c, d};
            double[] result;
            result = complex.binOp(comp1, comp2);
            String res = Arrays.toString(result).replace("[", "").replace("]", "");
            if (result[1] != 0) {
                output.setText("Output: (" + res + "i)");
            } else {
                output.setText("Output: (" + res + ")");
            }
        }
    }

    private double getPosImag(String posImag) {
        double b = 0;
        if (posImag.contains("i") && posImag.contains(")")) {
            posImag = posImag.replace("i", "");
            posImag = posImag.replace(")", "");
            if (!posImag.isEmpty()) {
                b = Double.parseDouble(posImag);
            }
            return b;
        }
        return b;
    }

    private double getNegImag(String negImag) {
        double b = 0;
        if (negImag.contains("i") && negImag.contains(")")) {
            negImag = negImag.replace("i", "");
            negImag = negImag.replace(")", "");
            if (!negImag.isEmpty()) {
                b = -Double.parseDouble(negImag);
            }
            return b;
        }
        return b;
    }
}
