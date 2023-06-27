package maths;

public class primeNum {
    public static void main(String[] args) {
        int n = 36;
        System.out.println(isPrime(n));
    }

    private static boolean isPrime(int n) {
        if (n<2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) // i*i <= n squared both the sides
        {
            if (n%i == 0) return false;
        }
        return true;
    }
}
// Time Complexity -> O(sqrt(n))