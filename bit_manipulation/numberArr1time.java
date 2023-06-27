package bit_manipulation;

public class numberArr1time {
    public static void main(String[] args) {
        int[] arr = {2,5,9,3,4,5,2,3,6,9,4};
        System.out.println("Number which have freq 1 =" + findNum(arr));
    }

    private static int findNum(int[] arr) {
        int unique =0;
        for (int j : arr) {
            unique = unique ^ j;
        }
        return unique;
    }

}
