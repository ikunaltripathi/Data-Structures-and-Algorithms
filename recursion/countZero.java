package recursion;

public class countZero {
    public static void main(String[] args) {
        int n = 408005;
        System.out.println(count(n));
    }

    private static int count(int n) {
        return helper(n, 0);
    }
    private static int helper(int n, int count) {
        if (n==0) return count;
        if (n%10 == 0) return helper(n/10, ++count);
        return helper(n/10, count);
    }
}
