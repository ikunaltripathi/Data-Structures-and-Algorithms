package searching;

public class kokoBananas {
    public static void main(String[] args) {
        int[] arr = {3,6,7,11};
        System.out.println(minEatingSpeed(arr, 8));
    }
        static int minEatingSpeed(int[] piles, int h) {
            int start = 1;
            int end = Integer.MIN_VALUE;
            for (int i =0; i<piles.length; i++)
            {
                end = Math.max(end, piles[i]);
            }
            while (start<end)
            {
                int mid = start + (end-start)/2;
                int hours = 0;
                for (int o : piles) {
                    if (o<=mid)
                    {
                        hours++;
                    }
                    else {
                        double temp = Math.ceil(o/mid);
                        hours +=(int)temp;
                    }
                }
                if (hours<=h) end = mid;
                else start = mid+1;
            }
            return end;
        }
}
