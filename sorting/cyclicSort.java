package sorting;

import java.util.Arrays;

public class cyclicSort {
    public static void main(String[] args) {
    int[] arr = {3,2,3,4,1};
        System.out.println(Arrays.toString(cycSort(arr)));
    }

    private static int[] cycSort(int[] nums) {
        int i= 0;
        while (i<nums.length) {
            int correct = nums[i] -1;
            if (nums[correct] != nums[i]) {
                int temp = nums[correct];
                nums[correct] = nums[i];
                nums[i] = temp;
            }
            else {
                i++;
            }
        }
        return nums;
    }

}
