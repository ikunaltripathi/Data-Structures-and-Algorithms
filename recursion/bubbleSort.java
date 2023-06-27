package recursion;

import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int[] arr = {3,4,1,2,7,5,2,1};
        sortRec(arr, arr.length, 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortRec(int[] nums, int n, int i) {
        if (n==1) return;
        if (i<n) {
            if (nums[i] < nums[i-1]) {
                int temp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = temp;
            }
            sortRec(nums, n, i+1);
        }
        else {
            sortRec(nums, n-1, 1);
        }
    }
}
