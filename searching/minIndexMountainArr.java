package searching;

public class minIndexMountainArr {
    public static void main(String[] args) {
        int[] arr = {1,5,2};
        System.out.println(findInMountainArray(2, arr));
    }
        public static int findInMountainArray(int target, int[] mountainArr) {
            int start=0;
            int end = mountainArr.length-1;
            while(start<end)
            {
                int mid = start + (end-start)/2;
                if (mountainArr[mid]>mountainArr[mid+1]) end =mid;
                else start = mid+1;
            }
            start = 0;
            int temp =end;
            while (start<=end)
            {
                int mid = start+(end-start)/2;
                if (mountainArr[mid]==target) return mid;
                else if (mountainArr[mid]<target) start = mid+1;
                else end = mid-1;
            }
            end = mountainArr.length-1;
            while (temp<=end)
            {
                int mid = temp+(end-temp)/2;
                if (mountainArr[mid]==target) return mid;
                else if (mountainArr[mid]<target) end = mid-1;
                else temp = mid+1;
            }
            return -1;
        }
}
