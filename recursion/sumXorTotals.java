package recursion;

public class sumXorTotals {

    public static void main(String[] args) {
        int[] nums = {1,3};
        System.out.println(helper (nums, 0,0));
    }
        public static int helper(int[] nums, int i, int Xor) {
            if (i==nums.length) return Xor;
            int x = helper (nums, i+1, Xor^nums[i]);
            int y = helper (nums, i+1, Xor);
            return x+y;
        }
}
