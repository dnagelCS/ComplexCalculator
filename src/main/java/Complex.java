public class Complex {

    private double[] a;
    private double[] b;
    private String[] operators = {"+", "-", "*", "/"};
    int choice = 0;

    public void setA(double[] a) {
        this.a = a;
    }

    public void setB(double[] b) {
        this.b = b;
    }

    public void setChoice(String opStr) {
        for (int i = 0; i < operators.length; i++) {
            if(opStr.equals(operators[i])) {
                choice = i;
            }
        }
    }

    public double[] binOp(double[] a, double[] b) {
        this.a = a;
        this.b = b;
        double[] result;

        //make sure both arrays are of equal length
        if (a.length == b.length) {
            //default
            result = add(a,b);
            //add
            if(choice == 0) {
                result = add(a,b);
            }
            //subtract
            else if (choice == 1) {
                result = subtract(a,b);
            }
            //multiply
            else if (choice == 2) {
                result = multiply(a,b);
            }
            //divide
            else if (choice == 3) {
                result = divide(a,b);
            }
            return result;
        }
        else throw new IllegalArgumentException();
    }

    public static double[] add(double[] a, double[] b) {
        if (a.length == b.length) {
            int length = a.length;

            double[] result = new double[length];

            for (int i = 0; i < length; i++) {
                result[i] = a[i] + b[i];
            }
            return result;
        } else throw new IllegalArgumentException();
    }

    public static double[] subtract(double[] a, double[] b) {
        if (a.length == b.length) {
            int length = a.length;

            double[] result = new double[length];

            for (int i = 0; i < length; i++) {
                result[i] = a[i] - b[i];
            }
            return result;
        } else throw new IllegalArgumentException();
    }

    public static double[] multiply(double[] a, double[] b) {
        if (a.length == b.length) {
            int length = a.length;

            double[] result = new double[length];

            for (int i = 0; i < length; i++) {
                result[i] = a[i] * b[i];
            }
            return result;
        } else throw new IllegalArgumentException();
    }

    public static double[] divide(double[] a, double[] b) {
        if (a.length == b.length) {
            int length = a.length;

            double[] result = new double[length];

            for (int i = 0; i < length; i++) {
                result[i] = a[i] / b[i];
            }
            return result;
        } else throw new IllegalArgumentException();
    }

    public String toString() {
        return "(" + a[0] + ", " + a[1] + "i) " + operators[choice] + " (" +
                b[0] + ", " + b[1] + "i)";
    }
}
