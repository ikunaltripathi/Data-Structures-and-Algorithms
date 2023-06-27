package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// https://drive.google.com/drive/u/1/folders/1QeYgbGOgqn-ULttVhFQcdakKIXxNKKRD

public class SubsequenceWithConstraints {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
       func(3, nums,new ArrayList<>(), ans,  0);
       int res= 1;
        for (List<Integer> i : ans) {
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for (int x : i) {
                if (x >= max) max = x;
                if (x <= min) min = x;
            }
            for (int j : i) {
                if (j == min || j == max) continue;
                res *= j;
            }

        }
        System.out.println(ans);
        System.out.println(res);
    }
    public static void func(int x, int[] nums, ArrayList<Integer> al, List<List<Integer>> ans, int index) {
        if (al.size() == x) ans.add(new ArrayList<>(al));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) continue;//for duplicate checking
            al.add(nums[i]);
            func(x, nums, al, ans, i + 1);
            al.remove(al.size() - 1);
        }
    }
}
