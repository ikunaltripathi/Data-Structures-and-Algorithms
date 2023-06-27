package recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class linearSearch {
    public static void main(String[] args) {
        int[] arr = {2,5,1,6,8,34,23,73,4,2};
//        System.out.println(searchx(arr, 66, 0));
        System.out.println(searchy(arr, 2
                , 0));
    }
     public static boolean searchx(int[] nums, int target, int i) {
        if (i>=nums.length-1) return false;

        return nums[i] == target || searchx(nums, target, i+1);
    }


    // returning the list without taking it in argument
    static ArrayList<Integer> searchy (int[] nums, int target, int i) {
        ArrayList<Integer> al = new ArrayList<>();
        if (i==nums.length) {
            return al;
        }
        if (nums[i] == target) {
            al.add(i);
        }
        ArrayList<Integer> ansFromBottomFunctions = searchy(nums, target, i+1);
        al.addAll(ansFromBottomFunctions);
        return al;
    }
}
