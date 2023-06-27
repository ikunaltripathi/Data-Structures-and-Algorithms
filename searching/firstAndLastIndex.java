package searching;

import java.util.Arrays;

public class firstAndLastIndex {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(fun(nums,target)));

    }

    private static int[] fun(int[] nums , int target) {
        int[] arr=new int[2];
        int start = 0;
        int end = nums.length-1;
        while(start<=end)
        {
            int mid = start + (end-start)/2;
            if (nums[mid] < target) start= mid+1;
            else end = mid-1;
        }
        arr[0] = start;
        start=0;
        end= nums.length-1;
        while(start<=end)
        {
            int mid = start + (end-start)/2;
            if (nums[mid] > target) end = mid-1;
            else start = mid+1;
        }
        arr[1] = end;
        return arr;
    }
}
