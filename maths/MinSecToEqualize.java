package maths;

import java.util.*;

public class MinSecToEqualize {
    public static void main(String[] args) {
        Integer[] arr = {2,1,3,3,2};
        List<Integer> al = new ArrayList<>(Arrays.asList(arr)); // al.addAll() expects an object not primitives so convert int[] to Integer[]
        System.out.println(minimumSeconds(al));
    }
    public static int minimumSeconds(List<Integer> nums) {
        Map<Integer, List<Integer>> hm = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for (int i=0; i<nums.size(); i++) {
            int ele = nums.get(i);
            if (!hm.containsKey(ele)) hm.put(ele, new ArrayList<>());
            hm.get(ele).add(i);
        }
        nums.addAll(nums);
        for (Integer v : hm.keySet()) {
            List<Integer> al = hm.get(v);
            int curr = 0;
            // int start = al.get(0);
            // int end = nums.size()-1-al.get(al.size()-1);
            // int curr = (start+end+1)/2;
            for (int i=1; i<al.size(); i++) {
                curr = Math.max(curr, (al.get(i)-al.get(i-1))/2);
            }
            ans = Math.min(curr, ans);
        }
        return ans;
    }
}
