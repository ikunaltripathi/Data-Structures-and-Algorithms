package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//public class permutationsII {
//    public static void main(String[] args) {
//        int[] arr = {1,2,2};
//        System.out.println(permuteUnique(arr));
//    }
//    public static List<List<Integer>> permuteUnique(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        Arrays.sort(nums);
//        helper (res, nums, new ArrayList<Integer>(), new boolean[nums.length]);
//        return res;
//    }
//    public static void helper(List<List<Integer>> res, int[] nums, ArrayList<Integer> al, boolean[] used) {
//        if (al.size() == nums.length) {
//            res.add(new ArrayList<>(al));
//            return;
//        }
//        for (int i = 0; i<nums.length; i++) {
//            if (used[i] || (i>0 && nums[i] == nums[i-1] && !used[i-1])) continue;
//            al.add(nums[i]);
//            used[i] = true;
//            helper(res, nums, al, used);
//            used[i] = false;
//            al.remove(al.size()-1);
//        }
//    }
//}

public class permutationsII {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        System.out.println(permuteUnique(arr));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, res, 0);
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
        for (int i = index; i < arr.length; i++) {
            if (i != index && !canPermute(index, i, arr)) continue;
            swap(i, index, arr);
            helper(arr, res, index + 1);
            swap(i, index, arr);
        }
    }

    public static boolean canPermute(int index, int curr, int[] nums) {
        for (int i = index; i < curr; i++) {
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
