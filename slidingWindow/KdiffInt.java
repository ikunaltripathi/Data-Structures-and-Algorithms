package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class KdiffInt {
    public static void main(String[] args) {
        int[] nums = {2,1,1,1,2};
        System.out.println(subarraysWithKDistinct(nums, 1));
    }
    public static int subarraysWithKDistinct(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        int count = 0, i = 0, j = 0, ans = 0, temp = 0;
        while (j < nums.length) {
            if (!hm.containsKey(nums[j])) temp = 0;
            hm.put(nums[j], hm.getOrDefault(nums[j], 0) + 1);
            if (hm.get(nums[j]) == 1) count++;
            while (count == k) {
                temp++;
                hm.put(nums[i], hm.get(nums[i]) - 1);
                if (hm.get(nums[i]) == 0) count--;
                i++;
            }
            ans += temp;
            j++;
        }
        return ans;
    }
}
