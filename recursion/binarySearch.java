package recursion;

public class binarySearch {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        System.out.println(search(arr, target));
    }
         static int search(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;

            return helper (nums, target, start, end);
        }

        public static int helper(int[] arr, int target, int s, int e)
        {
            int mid = s + ((e-s)/2);
            if (s>e) return -1;  // important
            if (arr[mid] == target) return mid;
            if (arr[mid] > target) return helper (arr, target, s, mid-1);
            return helper (arr, target, mid+1, e);
        }
    }