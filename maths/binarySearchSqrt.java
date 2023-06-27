package maths;

public class binarySearchSqrt {
    public static void main(String[] args) {
        int n  = 40, p = 3;
        System.out.println(findsqrt(n, p));

    }

    private static double findsqrt(int n, int p) {
        int start = 0, end = n;
        double root = 0.0;
        int mid = 0;
        while (start<=end) {
            mid = start + (end - start) / 2;
            if (mid * mid == n) return mid;
            if ((mid * mid) > n) end = mid - 1;
            else if ((mid * mid) < n)
            {
                start = mid + 1;
                root = mid;
            }

        }
        double incr = 0.1;
        for (int i = 0; i < 3; i++) {
            root += incr;
            while (root * root < n){
                root += incr;
            }
            root -= incr;
            incr /= 10;
        } return root;
    }
}
