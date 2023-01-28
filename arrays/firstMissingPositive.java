package arrays;

class firstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0 || nums == null) return 1;
        int containsOne = 0;
        for (int i = 0; i<nums.length; i++)
        {
            if (nums[i] == 1) containsOne = 1;
            else if (nums[i]<=0 || nums[i]>nums.length)
            {
                nums[i] = 1;
            }
        }
        if (containsOne == 0) return 1;

        for (int i = 0; i<nums.length; i++)
        {
            int index = Math.abs(nums[i])-1;
            if (nums[index]>0)
                nums[index] = -1 * nums[index];
        }

        for (int i = 0; i< nums.length; i++)
        {
            if (nums[i]>0) return i+1;
        }
        return nums.length+1;
    }
}
