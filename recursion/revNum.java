package recursion;

public class revNum {
    static int ans = 0;
    public static void main(String[] args) {
        int n = 123;
        System.out.println(rev(n));
    }

    // by using helper function
    public static int rev(int n) {
//        if (n==0) return;
//        ans = (ans * 10) + (n%10);
//        rev(n/10);
        int digits = (int)(Math.log10(n) + 1);
        return helper(n, digits - 1);
    }

    private static int helper(int n, int i)
    {
        if (n%10==n) return n;
        int temp = n%10;
        n=n/10;
        return (temp * (int)Math.pow(10,i)) + helper(n, i-1);
    }
}
