package dynamic.BestTimeToBuyAndSellStock_II_122;

/**
 * 122. Best Time to Buy and Sell Stock II
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock
 * before you buy again).
 *
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 *
 * Example 2:
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 *
 * Example 3:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class Solution {
    /*
        x0 - cur profit and you do not have stock
        x1 - cur profit and you have stock

        on the next day:
        x0' = max(x0, x1 + p)
        x1' = max(x1, x0 - p)
    */
    // tc O(n), sc O(1)
    public int maxProfit(int[] prices) {
        int x0 = 0, x1 = Integer.MIN_VALUE;
        for (int p : prices) {
            int x0_ = x0;
            x0 = Math.max(x0, x1 + p);
            x1 = Math.max(x1, x0_ - p);
        }
        return Math.max(x0, x1);
    }

    // tc O(n), sc O(1)
    // 1 ms, faster than 91.85%; 42.5 MB, less than 5.71%
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
