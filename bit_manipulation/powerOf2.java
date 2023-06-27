package bit_manipulation;

public class powerOf2 {
    public static void main(String[] args) {
        int n = 16;
        boolean ans;
        if (n==0) ans = false;
        else {
        ans = (n&(n-1))== 0;
        }
        System.out.println(ans);
    }
}
