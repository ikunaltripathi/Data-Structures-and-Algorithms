package backtracking;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class kEqualSubsets {
    public static void main(String[] args) {
        int[] nums = {4,3,2,3,5,2,1};
        Arrays.sort(nums);
        System.out.println(canPartitionKSubsets(nums, 4));
    }
        public static boolean canPartitionKSubsets(int[] nums, int k) {
            if (nums.length<k || nums.length == 0) return false;
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            for (int i = 0; i<k; i++) {
                res.add(new ArrayList<>());
            }
            return helper(nums, k, 0,0, res);
        }

        public static boolean helper(int[] nums, int k, int index, int fSets, ArrayList<ArrayList<Integer>> ans) {
            if (index == nums.length) {
                if (fSets == k) {
                    System.out.println(ans);
                    int sum = 0, pSum = 0;
                    for (int i = 0; i < ans.size(); i++) {
                        for (int z = 0; z < ans.get(i).size(); z++) {
                            sum += ans.get(i).get(z);
                        }
                        if (i == 0) pSum = sum;
                        else if (sum != pSum) return false;
                    }
                    return true;
                }
                return false;
            }
            boolean x = false;
            for (int i  = 0; i<ans.size(); i++) {
                if ((ans.get(i)).size() > 0) {
                    ans.get(i).add(nums[index]);
                    x = x || helper (nums, k,index+1, fSets, ans);
                    ans.get(i).remove(ans.get(i).size()-1);
                }
                else {
                    ans.get(i).add(nums[index]);
                    x= x ||  helper (nums, k, index+1, fSets+1, ans);
                    ans.get(i).remove(ans.get(i).size()-1);
                    break;
                }
            }
            return x;
        }
}
