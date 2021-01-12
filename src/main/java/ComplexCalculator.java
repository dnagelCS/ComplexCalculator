import java.util.Arrays;
import java.util.Scanner;

public class ComplexCalculator {
    public static void main(String[] args) {
        new CalcFrame().setVisible(true);

        Scanner input = new Scanner(System.in);
        Complex complex = new Complex();
        double[] a = {5,2};
        double[] b = {3,-7};
        double[] result;

        complex.setA(a);
        complex.setB(b);
        System.out.println("Input: " + complex.toString());

        result = complex.binOp(a,b);
        System.out.println("Output: " + Arrays.toString(result));
    }

}
