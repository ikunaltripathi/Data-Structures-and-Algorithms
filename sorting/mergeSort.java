package sorting;

import java.util.Arrays;

public class mergeSort {
    public static void main(String[] args) {
        int arr[] = {4,32,12,5,1,3,6,3,87,4,9,2};
//        int arr[] = {8,9,3};
//        System.out.println(Arrays.toString(sortFun(arr)));
        sortInplaceFun(arr, 0 , arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortInplaceFun(int[] nums, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = start + (end - start)/2;
        sortInplaceFun(nums, start, mid);
        sortInplaceFun(nums, mid+1,end);
        int[] merge = new int[end-start+1];
        int j=start, k = mid+1;
        for (int i = 0; i< merge.length; i++) {
            if (j > mid) {
                while (k <= end) {
                    merge[i++] = nums[k++];
                }
                break;
            } else if (k > end) {
                while (j <= mid) {
                    merge[i++] = nums[j++];
                }
                break;
            } else {
                if (nums[j] <= nums[k]) merge[i] = nums[j++];
                else merge[i] = nums[k++];
            }
        }
        for (int i = 0; i<merge.length; i++) {
            nums[start+i] = merge[i];
        }
    }

    private static int[] sortFun(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }
        int mid = (nums.length-1)/2;
        int[] left = sortFun(Arrays.copyOfRange(nums, 0 , mid+1));
        int[] right = sortFun(Arrays.copyOfRange(nums, mid+1, nums.length));
        int[] merge = new int[left.length + right.length];
        int j=0, k =0;
        for (int i = 0; i< merge.length; i++) {
            if (j==left.length) {
                while (k<right.length) {
                merge[i++] = right[k++];
                }
                break;
            }
            else if (k == right.length) {
                while (j<left.length) {
                    merge[i++] = left[j++];
                }
                break;
            }
            else {
                if (left[j] <= right[k]) merge[i] = left[j++];
                else merge[i] = right[k++];
            }
        }

        return merge;
    }
}
