package sorting;

import java.util.Arrays;

public class radixSort {
    public static void main(String[] args) {
        int[] arr = {237, 146, 259, 348, 152, 163, 235, 48, 36, 62};
        sortFunc(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortFunc(int[] arr) {
        int max = getMax(arr, arr.length);
        for (int i = 1; max/i > 0; i*=10) {
            countingSort(arr, arr.length, i);
        }
    }
    private static void countingSort(int[] nums, int n, int exp) {
        int[] count = new int[10];
        int[] res = new int[nums.length];
        for (int i = 0; i<nums.length; i++) {
            count[(nums[i]/exp)%10]++;
        }
        for (int i = 1; i<10; i++) {
            count[i] += count[i-1];
        }
        for (int i = nums.length-1; i>=0; i--) {
            res[--count[(nums[i]/exp)%10]] = nums[i];
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
