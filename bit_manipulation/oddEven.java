package bit_manipulation;

public class oddEven {
    public static void main(String[] args) {
        int c=54;
        System.out.println(isOddOrEven(c));
    }

    private static boolean isOddOrEven(int c) {
        return (c&1) == 1;
    }

}
