package searching;

public class searchInRotatedArr {
    public static void main(String[] args) {
        int[]  arr = {1,3};
        System.out.println(searchInrotated(arr, 0));
    }

    private static int searchInrotated(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
        while (start<=end)
        {
            int mid = start + (end-start)/2;
            if (mid<end && arr[mid]>arr[mid+1]) return mid;
            else if (mid>start && arr[mid-1] > arr[mid]) return mid-1;
            else if (arr[mid] == arr[start] && arr[mid] == arr[end])
            {
                if (arr[start]>arr[start+1]) return start;
                start++;
                if (arr[end-1]>arr[end]) return end-1;
                end--;
            }
            else if(arr[start]<arr[mid] || arr[mid] == arr[start] && arr[mid]>arr[end]) start = mid+1;
            else end = mid-1;
        }
        return -1;
    }
}
