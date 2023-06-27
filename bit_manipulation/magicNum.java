package bit_manipulation;

public class magicNum {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(magic(n));
    }

    private static int magic(int n) {
        int counter = 1, res =0;
        while(n !=0)
        {
            res += Math.pow(5,counter);
            n= n>>1;
            counter++;
        }
        return res;
    }
}
