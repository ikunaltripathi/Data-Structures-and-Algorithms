package searching;
import java.util.*;

public class rowColSortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {20,30,40,55},
                {22,32,43,57},
                {33,38,49,61},
                {39,42,56,71}
        };
        System.out.println(Arrays.toString(rowColMatrix(arr,56)));
    }

    private static int[] rowColMatrix(int[][] arr, int target) {
        int row = 0;
        int col = arr.length-1;
//        while (row<=col)
        while (row<arr.length && col>=0)
        {
            if (arr[row][col]==target) return new int[]{row,col};
            else if(arr[row][col]>target) col--;
            else row++;
        }
        return new int[]{-1,-1};
    }
}
