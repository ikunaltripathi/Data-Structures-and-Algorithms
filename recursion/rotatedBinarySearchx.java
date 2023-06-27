package recursion;

public class rotatedBinarySearchx {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,1,3,4};
        System.out.println(searchs(arr, 3, 0, arr.length-1));
    }

    static int searchs(int[] nums, int target, int start, int end) {
        if (start>end) return -1;
        int mid = start + (end-start)/2;
        if (nums[mid] == target) return mid;

        if (nums[start] <= nums[mid]) {
            if (target >= nums[start] && target < nums[mid]) {
                return searchs(nums,target, 0,mid-1);
            }
            else {
                return searchs(nums,target, mid+1, end);
            }
        }
        else if (target > nums[mid] && target<= end) {
            return searchs(nums,target, mid+1,end);
        }
        else {
            return searchs(nums,target, start,mid-1);
        }
    }
}
