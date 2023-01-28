package arrays;

public class buyNsellStock3 {
    public static int maxProfit(int[] prices)
    {
    int minPrice1 = Integer.MAX_VALUE;
    int profit1 = 0;
    int minPrice2 = Integer.MAX_VALUE;
    int profit2 = 0;

    for(int i = 0; i<prices.length;i++)
    {
        minPrice1 = Math.min(prices[i], minPrice1);
        profit1 = Math.max(profit1, prices[i] - minPrice1);
        minPrice2 = Math.min(minPrice2, prices[i] - profit1);
        profit2 = Math.max(profit2, prices[i] - minPrice2);
    }
        return profit2;
}

    public static void main(String[] args) {
        int[] arr ={1,4,2,5};
        System.out.println(maxProfit(arr));
    }
}
