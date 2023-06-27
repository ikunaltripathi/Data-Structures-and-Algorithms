package sorting;

import java.util.Arrays;

public class quickSort {
    public static void main(String[] args) {
        int[] arr = {7,6,3,2,7,2,1,7,4,3};
        sortFunc(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortFunc(int[] arr, int low, int high) {
        if (low >= high) return;
        int s = low;
        int e = high;
        int mid = low + (high - low)/2;
        int pivot = arr[mid];
        while (s<=e) {
            while (arr[s] < pivot) s++;
            while (arr[e] > pivot) e--;
            if (s<=e) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
        sortFunc(arr, low , e);
        sortFunc(arr, s , high);
    }
}
