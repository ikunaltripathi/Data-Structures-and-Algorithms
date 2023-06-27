package sorting;

public class countInversions {
    public static void main(String[] args) {
//        int[] arr = {5,4,3,2,1};
        int[] arr = {2, 0, 1};
        int[] temp = new int[arr.length];
        int locInv = 0;
        for (int i = 0; i< arr.length-1; i++) {
            if (arr[i]>arr[i+1]) locInv++;
        }
        System.out.println(locInv);
//        System.out.println(inversionCount(arr, temp, 0, arr.length-1));
        int gblInv = inversionCount(arr, temp, 0 ,arr.length-1);
//        System.out.println(gblInv);
        if (gblInv == locInv) System.out.println("True");
        else System.out.println("False");;
    }

    private static int inversionCount(int[] nums, int[] temp, int start, int end) {
        int iCount = 0;
        if (end>start) {
            int mid = (start + end) / 2;
            iCount += inversionCount(nums, temp, start, mid);
            iCount += inversionCount(nums, temp, mid + 1, end);
            iCount += mergeiCount(nums, temp, start, mid + 1, end);
        }
        return iCount;
    }

    private static int mergeiCount(int[] nums, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid;
        int k = left;
        int iCount = 0;
        while ((i<=mid-1) && (j<=right)) {
            if (nums[i] <= nums[j]) temp[k++] = nums[i++];
            else {
                temp[k++] = nums[j++];
                iCount += (mid-i);
            }
        }
        while (i<=mid-1) temp[k++] = nums[i++];
        while (j<=right) temp[k++] = nums[j++];

        for (int l = left; l<=right; l++) {
            nums[l] = temp[l];
        }
        return iCount;
    }

}
