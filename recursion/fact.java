package recursion;

public class fact {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(fact(n));
    }
    static int fact(int x)
    {
        if (x <= 1) return 1;
        return x * fact(x-1);
    }

}
