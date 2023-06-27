package sorting;

import java.util.Arrays;

public class countSort {
    public static void main(String[] args) {
        int[] arr = {2,1,1,0,2,5,4,0,2,8,7,7,9,2,0,1,9};
        sortFunc(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortFunc(int[] nums) {
        int max = getMax(nums, nums.length);
        int[] count = new int[max+1];
        int[] res = new int[nums.length];
        for (int i = 0; i<nums.length; i++) {
            count[nums[i]]++;
        }
        for (int i = 1; i<max+1; i++) {
            count[i] += count[i-1];
        }
        for (int i = nums.length-1; i>=0; i--) {
            res[--count[nums[i]]] = nums[i];
        }
        for (int i = 0; i<nums.length; i++) {
            nums[i] = res[i];
        }
    }

    private static int getMax(int[] A, int n) {
        int max = A[0];
        for (int i = 1; i<n; i++) {
            if (A[i] > max) max = A[i];
        }
        return max;
    }
}
