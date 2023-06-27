package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// ITERATIVE SOLUTION
public class subsetArr {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
//        int[] arr = {1,2,2};
//        System.out.println(subsetsDup(arr));
//        System.out.println(sub
//        sets(arr));
        System.out.println(subsetsRec(arr));
    }
//    static public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> outer = new ArrayList<>();
//        outer.add(new ArrayList<>());
//        for (int num : nums) {
//            int n = outer.size();
//            for (int i = 0; i<n; i++) {
//                List<Integer> internal = new ArrayList<>(outer.get(i));
//                internal.add(num);
//                outer.add(internal);
//            }
//        }
//        return outer;
//    }
//    static public List<List<Integer>> subsetsDup(int[] nums) {
//        Arrays.sort(nums);
//        List<List<Integer>> outer = new ArrayList<>();
//        outer.add(new ArrayList<>());
//        int start = 0;
//        int end = 0;
//        for (int i = 0; i<nums.length; i++) {
//            int n = outer.size();
//            start = 0;
//            if (i!=0 && nums[i] == nums[i-1]) {
//                start = end + 1;
//            }
//            end = n-1;
//                for (int j = start; j < n; j++) {
//                    List<Integer> internal = new ArrayList<>(outer.get(j));
//                    internal.add(nums[i]);
//                    outer.add(internal);
//                }
//        }
//        return outer;
//    }

//    recursive solution
public static List<List<Integer>> subsetsRec (int[] nums) {
    List<List<Integer>> res = new ArrayList();
    helper(nums, new ArrayList<Integer>(), res,  0);
    return res;
}
    public static void helper(int[] nums,ArrayList<Integer> al,List<List<Integer>> ans, int index){
        ans.add(new ArrayList<>(al));
        for(int i=index;i<nums.length;i++){
            al.add(nums[i]);
            helper(nums,al,ans, i+1);
            al.remove(al.size()-1);
        }
    }
}


