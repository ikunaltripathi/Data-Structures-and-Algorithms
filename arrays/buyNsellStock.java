package arrays;
//121. Best Time to Buy and Sell Stock
//        Easy
//        You are given an array prices where prices[i] is the price of a given stock on the ith day.
//
//        You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//
//        Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
//
//
//
//        Example 1:
//
//        Input: prices = [7,1,5,3,6,4]
//        Output: 5
//        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//        Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.



public class buyNsellStock {
        public static int maxProfit(int[] prices) {
            int minPrice = Integer.MAX_VALUE;
            int maxProfit = 0;
            for (int i = 0; i<prices.length; i++)
            {
                if (prices[i]<minPrice) minPrice = prices[i];
                if (maxProfit<(prices[i]-minPrice)) maxProfit = prices[i]-minPrice;
            }
            return maxProfit;
        }

    public static void main(String[] args) {
        int[] prices = {2,3,9,2,5,12,5};
        System.out.println(maxProfit(prices));
    }
}
