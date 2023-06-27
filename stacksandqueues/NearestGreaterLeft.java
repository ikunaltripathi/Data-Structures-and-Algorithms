package stacksandqueues;

import java.util.Arrays;
import java.util.Stack;

public class NearestGreaterLeft {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4};
        System.out.println(Arrays.toString(nearestLeft(arr)));
    }

    private static int[] nearestLeft(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stck = new Stack<>();
        for (int i = 0; i<arr.length; i++) {
            if (stck.isEmpty()) ans[i] = -1;
            else {
                while (!stck.isEmpty() && stck.peek() <= arr[i]) stck.pop();
                if (stck.isEmpty()) ans[i] =-1;
                else ans[i] = stck.peek();
            }
            stck.push(arr[i]);
        }
        return ans;
    }
}
