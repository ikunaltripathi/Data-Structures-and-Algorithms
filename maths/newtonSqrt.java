package maths;

public class newtonSqrt {
    public static void main(String[] args) {
        int n = 40;
        double p = 0.5;

        System.out.println(findSqrt(n, p));
    }

    private static double findSqrt(int n, double p) {
         double x = n;
        double root = 0.0;
        while (true)
        {
            root  = 0.5 * (x + (n/x));
            if (Math.abs(root - x) < p) break;
            x = root;
        } return root;
    }

}
