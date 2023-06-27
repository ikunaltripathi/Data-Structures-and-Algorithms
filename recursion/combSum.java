package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combSum {
    public static void main(String[] args) {
        int[] arr ={2,3,5};
        System.out.println(combinationSum(arr, 8));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper (candidates,0, target, 0, new ArrayList<Integer>());
        return res;
    }
    static List<List<Integer>> res = new ArrayList<>();
    public static void helper(int[] arr, int sum, int target, int index, ArrayList<Integer> al) {
        if (target == 0) {
            res.add(new ArrayList<>(al));
            return;
        }
        for (int i = index; i<arr.length && arr[i] <= target; i++) {
            al.add(arr[i]);
            helper (arr, sum+ arr[i], target - arr[i], i, al);
            al.remove(al.size()-1);
        }
    }
}
