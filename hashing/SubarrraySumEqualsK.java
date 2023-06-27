package hashing;

import java.util.HashMap;

public class SubarrraySumEqualsK {

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        System.out.println(subarraySum(nums,2));
    }

    public static int subarraySum(int[] nums, int k) {
            HashMap<Integer, Integer> hm = new HashMap<>();
            int sum = 0, count = 0;
            for (int i=0; i<nums.length; i++) {
                sum += nums[i];
                if(sum==k) count++;
                if (hm.containsKey(sum-k)) count += hm.get(sum-k);
                hm.put(sum, hm.getOrDefault(sum,0)+1);
            }
            return count;
    }
}
