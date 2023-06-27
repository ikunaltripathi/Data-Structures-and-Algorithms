package sorting;

import java.util.Arrays;

public class insertionSort {
    public static void main(String[] args) {
        int[] arr = {10, 5,6,3,2,10,1};
        System.out.println(Arrays.toString(insSort(arr)));
    }

    private static int[] insSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i+1;
            while (j>0) {
                if (nums[j] < nums[j-1]) {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
                else break;
                j--;
            }
        }
        return nums;

    }
}
