package searching;

public class rotatedBSDuplicates {
    public static void main(String[] args) {
        int[] arr = {2,5,6,0,0,1,2};
        System.out.println(findpivot(arr));

    }

    static int findpivot(int[] arr)
    {
        int start = 0;
        int end = arr.length-1;
        while (start<=end)
        {
            int mid = start + (end-start)/2;
            if (mid<end && arr[mid]>arr[mid+1]) return mid;
            else if (mid>start && arr[mid-1] > arr[mid]) return mid-1;
            if (arr[start]>arr[mid])
            {
                while (mid>start && arr[mid-1] == arr[mid])
                {
                    mid--;
                }
                end = mid-1;
            }
            else
            {
                while (mid<end && arr[mid+1] == arr[mid])
                {
                    mid++;
                }
                start = mid+1;
            }
        }
        return -1;// it means array is not rotated
    }
}
