package stacksandqueues;

import java.util.Stack;

public class maximalRect {
    public static void main(String[] args) {
        char[][] mat = {{'1'},{'0'},{'1'},{'1'},{'1'},{'1'},{'0'}};
        System.out.println(maximalRectangle(mat));
    }
    public static int maximalRectangle(char[][] matrix) {
        if (matrix[0].length == 1 && matrix.length == 1) return matrix[0][0]-48;
        int[] arr = new int[matrix[0].length];
        int maximum = Integer.MIN_VALUE;
        for (int i = 0; i<matrix.length; i++) {
            for (int j = 0; j<matrix[0].length; j++) {
                int curr = matrix[i][j]-48;
                if (curr == 1) arr[j]++;
                else arr[j] = 0;
            }
            maximum = Math.max(maxAreaHisto(arr), maximum);
        }
        return maximum;
    }

    public static int maxAreaHisto(int[] arr) {
        Stack<Integer> stck = new Stack<>();
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        for (int i = 0; i<arr.length; i++) {
            while (!stck.isEmpty() && arr[stck.peek()] >= arr[i]) stck.pop();
            if (stck.isEmpty()) left[i] = 0;
            else left[i] = stck.peek()+1;
            stck.push(i);
        }
        stck.clear();
        for (int i = arr.length-1; i>=0; i--) {
            while (!stck.isEmpty() && arr[stck.peek()] >= arr[i]) stck.pop();
            if (stck.isEmpty()) right[i] = arr.length-1;
            else right[i] = stck.peek()-1;
            stck.push(i);
        }
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i<arr.length; i++) {
            maxArea = Math.max(maxArea, arr[i] * (right[i]-left[i]+1));
        }
        return maxArea;
    }
}
