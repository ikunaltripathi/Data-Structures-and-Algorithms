package bit_manipulation;

public class countSetBits {
    public static void main(String[] args) {
        int n = 7;
        int counter = 0;
        while (n > 0)
        {
            n = n&(n-1);
            counter++;
        }
        System.out.println(counter);
    }
}
