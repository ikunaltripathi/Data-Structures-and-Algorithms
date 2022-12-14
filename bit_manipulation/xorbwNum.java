package bit_manipulation;

public class xorbwNum {
    public static void main(String[] args) {
        int a = 3, b = 9;
        System.out.println(res(b)^res(a-1));
//        for (int i = 0; i <= b; i++)             Bad complexity

//        {
//            btemp ^= i;
//        }
//        for (int i = 0; i<a-1; i++)
//        {
//            temp ^= i;
//        }
    }

    private static int res(int x) {
        if (x % 4 == 0) return 0;
        else if (x % 4 == 1) return 1;
        else if (x % 4 == 2) return x + 1;
        else  return 0;
    }
}

