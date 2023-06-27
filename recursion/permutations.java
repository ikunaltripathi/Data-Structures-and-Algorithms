package recursion;

import java.util.ArrayList;
import java.util.List;

public class permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
    static List<List<Integer>> res;
        public static List<List<Integer>> permute(int[] nums) {
            res = new ArrayList<>();
            helper (nums, new ArrayList<Integer>(), 0);
            return res;
        }
        public static void helper(int[] nums, ArrayList<Integer> al, int index) {
            if (index >= nums.length) {
                res.add(new ArrayList<>(al));
                return;
            }
            for (int i = 0; i<=index; i++) {
                al.add(i, nums[index]);
                helper(nums, al, index+1);
                al.remove(i);
            }
        }
}

// 2nd approach // This approach gives permutations in sorted order
//public class permutations {
//    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
//        System.out.println(permute(nums));
//    }
//    public static List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> al = new ArrayList<>();
//        boolean[] used = new boolean[nums.length];
//        helper (nums, al, res, used);
//        return res;
//    }
//
//    static void helper (int[] nums, List<Integer> al, List<List<Integer>> res, boolean[] used) {
//        if (al.size() == nums.length) {
//            res.add(new ArrayList<>(al));
//            return;
//        }
//
//        for (int i = 0; i<nums.length; i++) {
//            if (!used[i]) {
//                used[i] = true;
//                al.add(nums[i]);
//                helper(nums, al, res, used);
//                al.remove(al.size()-1);
//                used[i] = false;
//            }
//        }
//    }
//}

// 3rd Approach

//public class permutations {
//    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
//        System.out.println(permute(nums));
//    }
//
//    public static List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        helper (nums, res, 0);
//        return res;
//    }
//
//    public static void helper(int[] arr,List<List<Integer>> res, int index) {
//        if (index == arr.length) {
//            List<Integer> al = new ArrayList<>();
//            for (int i : arr) {
//                al.add(i);
//            }
//            res.add(al);
//            return;
//        }
//
//        for (int i = index; i<arr.length; i++) {
//            swap (i, index, arr);
//            helper (arr,  res, index+1);
//            swap (i, index, arr);
//        }
//
//    }
//
//    private static void swap(int i, int index, int[] arr) {
//        int temp = arr[i];
//        arr[i] = arr[index];
//        arr[index] = temp;
//    }
//}




