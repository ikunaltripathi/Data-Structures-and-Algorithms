package recursion;

public class sumOfDigits {
    public static void main(String[] args) {
        int n = 342;
        pass(n);
//        System.out.println(sum(n));

    }
    static void pass(int n)
    {
        if (n == 0) return;
        System.out.println(n);
        pass(n--);
    }

//    static int sum(int x)
//    {
//         if (x <= 0) return 0;
//        return (x%10) + sum(x/10);
//    }
}
