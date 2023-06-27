package sorting;

import java.util.Arrays;

public class selectionSort {
    public static void main(String[] args) {
        int[] arr = {7, 5, 3, 2, 7, 9};
        System.out.println(Arrays.toString(selSort(arr)));
    }

    private static int[] selSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int max = 0;
            int range = nums.length-i-1;
            for (int j = 1; j <= range; j++) {
                if (nums[j] > nums[max]) max = j;
            }
            int temp = nums[range];
            nums[range] = nums[max];
            nums[max] = temp;
        }
        return nums;
    }
}
