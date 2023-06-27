package stacksandqueues;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerRight {
    public static void main(String[] args) {
        int[] arr = {4,5,2,10,8};
        System.out.println(Arrays.toString(smallestRight(arr)));
    }
    private static int[] smallestRight(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stck = new Stack<>();
        for (int i = arr.length-1; i>=0; i--) {
            if (stck.isEmpty()) ans[i] = -1;
            else {
                while (!stck.isEmpty() && stck.peek() >= arr[i]) stck.pop();
                if (stck.isEmpty()) ans[i] =-1;
                else ans[i] = stck.peek();
            }
            stck.push(arr[i]);
        }
        return ans;
    }
}
