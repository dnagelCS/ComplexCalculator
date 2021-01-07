public class Complex {

    private double[] a;
    private double[] b;

    public double[] getA() {
        return a;
    }

    public double[] getB() {
        return b;
    }

    public void setA(double[] a) {
        this.a = a;
    }

    public void setB(double[] b) {
        this.b = b;
    }

    public double[] binOp(double[] a, double[] b) {
        this.a = a;
        this.b = b;
        double[] result;

        //add all operations

        //make sure both arrays are of equal length
        if (a.length == b.length) {
            //add
            result = add(a,b);
            return result;
            //subtract
            //multiply
            //divide
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

    public String toString() {
        return "(" + a[0] + ", " + a[1] + "i) + (" +
                b[0] + ", " + b[1] + "i)";
    }
}
