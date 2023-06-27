package recursion;

import java.util.Arrays;

public class selSort {
    public static void main(String[] args) {
        int[] arr = {1,6,5,23,8,9,3,1,5,7};
        func(arr, arr.length, 1, 0);
        System.out.println(Arrays.toString(arr));
    }

    private static void func(int[] nums, int n, int i, int max) {
        if (n == 1) return;
        if (i < n) {
            if (nums[i] > nums[max]) max = i;
            func(nums, n, i+1, max);
        }
        else {
            int temp = nums[i - 1];
            nums[i - 1] = nums[max];
            nums[max] = temp;
            func(nums, n - 1, 1, 0);
        }
    }
}
