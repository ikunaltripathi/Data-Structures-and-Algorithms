package searching;

public class infiniteArraySearch {
    public static void main(String[] args) {
        int[] nums = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int target = 10;
        System.out.println(bs(nums, target));
    }

    private static int bs(int[] nums, int target) {
        int start = 0;
        int end = 1;
        while (target>nums[end])
        {
            int temp = end+1;
            end = end + (end-start+1)*2;
            start = temp;
        }
        while (start<=end)
        {
            int mid = start + (end-start)/2;
            if (nums[mid]>target) end = mid-1;
            else if (nums[mid]<target) start = mid + 1;
            else return mid;
        }
        return -1;
    }
}