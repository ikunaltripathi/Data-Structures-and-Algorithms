package arrays;

import java.util.Arrays;

public class fourSum {
    public static void main(String[] args) {
        int target = -294967296;
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        Arrays.sort(nums);
        for (int i = 0; i<nums.length-3; i++)
        {
            for (int j = i+1; j<nums.length-2; j++)
            {
                long sum = ((long)target) - (nums[i] + nums[j]);
                int low = j+1;
                int high = nums.length-1;
                while (low<high)
                {
                    if (nums[low]+ nums[high] == sum)
                    {
                        while (low<high && nums[low] == nums[low+1]) low++;
                        while (low<high && nums[high] == nums[high-1]) high--;
                        low++;
                        high--;
                    }
                    else if ((nums[low]+ nums[high]) < sum) low++;
                    else high--;
                }
                while(j < (nums.length-1) && nums[j] == nums[j+1]) j++;
            }
            while(i < (nums.length-2) && nums[i] == nums[i+1]) i++;
        }
    }
}
