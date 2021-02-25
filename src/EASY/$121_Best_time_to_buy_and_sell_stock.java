package EASY;
/*

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */

public class $121_Best_time_to_buy_and_sell_stock {
    //solution 1
    //https://www.youtube.com/watch?v=JD8QaYVq5lQ
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0 ;
        }
        int max = 0 ;
        int lowest = prices[0] ;
        for (int i = 0 ; i < prices.length ; ++i) {
            if (prices[i] > lowest) {
                max = Math.max(max, prices[i] - lowest) ;
            } else{
                lowest = prices[i];
            }
        }
        return  max ;
    }

    //solution 2: Kadane's Algorithm, convert it to maximum subarray problem
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock/discuss/39038/Kadane's-Algorithm-Since-no-one-has-mentioned-about-this-so-far-%3A)-(In-case-if-interviewer-twists-the-input)
    public static int maxProfit2(int[] prices) {
        if(prices.length <= 1) return 0;
        int maxCur = 0;
        int maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur += prices[i] - prices[i-1];
            maxCur = Math.max(0, maxCur);
            maxSoFar = Math.max(maxSoFar, maxCur);
        }

        return maxSoFar;
    }

    public static void main(String [] args){

    }
}
