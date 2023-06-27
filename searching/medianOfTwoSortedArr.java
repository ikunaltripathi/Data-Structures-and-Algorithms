package searching;
public class medianOfTwoSortedArr {
    public static void main(String[] args) {
        int[] arr1 = {0, 0};
        int[] arr2 = {0};
        System.out.println(findMedianSortedArr(arr1, arr2));

    }

    static double findMedianSortedArr(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if (length % 2 != 0) {
            int med = ((length + 1) / 2) - 1;
            double ans = (double) searchf(nums1, nums2, med, 0);
            return ans;
        } else {
            int med = (length / 2) - 1;
            double ans = ((double) searchf(nums1, nums2, med, 0) + searchf(nums1, nums2, med + 1, 0)) / 2.00;
            return ans;
        }
    }

    static int searchf(int[] arr1, int[] arr2, int index, int freq) {
        int start = 0;
        int end = arr1.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int lastPosition = mid + (position(arr2, arr1[mid], false));
            int firstPosition = mid + (position(arr2, arr1[mid], true));
            if (index >= firstPosition && index <= lastPosition) {
                return arr1[mid];
            } else if (lastPosition > index) end = mid - 1;
            else start = start + 1;
        }
        if (freq == 1) return -1;
        return searchf(arr2, arr1, index, 1);
    }

    static int position(int[] nums, int target, boolean FirstOccurence) {
        int start = 0;
        int end = nums.length - 1;
        if (FirstOccurence == false) {
            if (nums[nums.length - 1] <= target) return nums.length;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] > target) end = mid - 1;
                else start = mid + 1;
            }
            return start;
        } else {
            if (target <= nums[0]) return 0;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] < target) start = mid + 1;
                else end = mid - 1;
            }
            return start;
        }
    }
}
