package arrays;

public class containerWithMostWater {
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }
    // getting TLE
        public static int maxArea(int[] height) {
            int max = 0;
            int start = 0;
            int end = height.length-1;                                     // O (N) Time Complexity
            while (start<end)
            {
                int h = Math.min(height[start],height[end]);
                int area = (end-start) * h ;
                max = Math.max(area, max);
                if (height[start] == height[end])
                {
                    start++;
                    end--;
                }
                else if (h==height[start]) start++;
                else end--;
            }
            return max;
        }
}
