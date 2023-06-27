package bit_manipulation;

public class findDigits {
    public static void main(String[] args) {
        int n=456;
        int res = (int)(Math.log(n) / Math.log(10)) + 1;
        System.out.println(res);
    }
}
