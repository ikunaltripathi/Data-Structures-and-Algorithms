package recursion;

import java.util.ArrayList;
import java.util.List;

public class permutations2 {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(permuteUnique(nums));
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper (nums, res, 0);
        return res;
    }

    public static void helper(int[] arr, List<List<Integer>> res, int index) {
        if (index == arr.length) {
            List<Integer> al = new ArrayList<>();
            for (int i : arr) {
                al.add(i);
            }
            res.add(al);
            return;
        }
        for (int i = index; i<arr.length; i++) {
            if (i!=index && !canPermute(index, i, arr)) continue;
            swap (i, index, arr);
            helper (arr,  res, index+1);
            swap (i, index, arr);
        }
    }
    public static boolean canPermute(int index, int curr, int[] nums) {
        for (int i = index; i< curr; i++) {
            if (nums[i] == nums[curr]) return false;
        }
        return true;
    }
    public static void swap(int i, int index, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }
}
