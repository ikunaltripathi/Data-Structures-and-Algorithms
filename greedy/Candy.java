package greedy;

public class Candy {
    public static void main(String[] args) {
        int[] ratings = {1,0,2};
        System.out.println(candy(ratings));
    }
        public static int candy(int[] ratings) {
            int[] left = new int[ratings.length];
            left[0] = 1;
            for (int i = 1; i < ratings.length; i++) {
                if (ratings[i] > ratings[i - 1]) left[i] = left[i - 1] + 2;
                else left[i] = 1;
            }
            int res = left[ratings.length - 1];
            int prev = 1;
            for (int i = ratings.length - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    prev++;
                    res += Math.max(prev, left[i]);
                } else {
                    prev = 1;
                    res += Math.max(prev, left[i]);
                }
            }
            return res;
        }
}
