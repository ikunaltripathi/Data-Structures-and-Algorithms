package sorting;

import java.util.Arrays;

public class countSmallerNumbers {
    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        int[] counts = new int[nums.length];
        int[] indexes = new int[nums.length];
        for (int i = 0; i<nums.length; i++) {
            indexes[i] = i;
        }
        inversionCount(nums, indexes, counts, 0, nums.length-1);
        System.out.println(Arrays.toString(counts));
    }

    static void inversionCount(int[] nums, int[] indexes, int[] counts, int start, int end) {
        if (end <= start) return;
        int mid = (start + end) / 2;
        inversionCount(nums, indexes,counts, start, mid);
        inversionCount(nums, indexes, counts, mid + 1, end);
        mergeiCount(nums, indexes, counts, start, end);
    }

    static void mergeiCount(int[] nums, int[] indexes, int[] counts, int start, int end){
        int mid = (start + end)/2;
        int i = start;
        int j = mid+1;
        int k = 0;
        int rightCount = 0;
        int[] newIndexes = new int[end - start + 1];
        while ((i<=mid) && (j<=end)) {
            if (nums[indexes[j]] < nums[indexes[i]]) {
                newIndexes[k] = indexes[j];
                rightCount++;
                j++;
            }
            else {
                newIndexes[k] = indexes[i];
                counts[indexes[i]] += rightCount;
                i++;
            }
            k++;
        }
        while (i<=mid) {
            newIndexes[k] = indexes[i];
            counts[indexes[i]] += rightCount;
            i++;
            k++;
        }
        while (j<=end) {
            newIndexes[k++] = indexes[j++];
        }

        for (int l = start; l<=end; l++) {
            indexes[l] = newIndexes[l-start];
        }
    }
}
