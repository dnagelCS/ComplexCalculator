import java.util.Arrays;
import java.util.Scanner;

public class ComplexCalculator {
    public static void main(String[] args) {
        Complex complex = new Complex();
        double[] a = {5,2};
        double[] b = {3,-7};

        complex.setA(a);
        complex.setB(b);
        System.out.println("Input: " + complex.toString());

        double[] result;

        result = complex.binOp(a,b);
        System.out.println("Output: " + Arrays.toString(result));
    }

}
