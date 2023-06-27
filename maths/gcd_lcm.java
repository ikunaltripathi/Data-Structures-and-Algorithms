package maths;

public class gcd_lcm {
    public static void main(String[] args) {
        System.out.println(gcd(105, 224));
        System.out.println(lcm(5, 9));
    }

    private static int lcm(int x, int y) {
        return (x*y) / gcd(x,y);
    }

    private static int gcd(int a, int b) {
        if (a==0) return b;
        return gcd(b%a, a);
    }
}
