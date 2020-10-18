package dynamic.BestTimeToBuyAndSellStock_IV_188;

import java.util.Arrays;

/**
 * 188. Best Time to Buy and Sell Stock IV
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 *
 * You are given an integer array prices where prices[i] is the price
 * of a given stock on the ith day.
 *
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 *
 * Notice that you may not engage in multiple transactions simultaneously
 * (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 * Input: k = 2, prices = [2,4,1]
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 *
 * Example 2:
 * Input: k = 2, prices = [3,2,6,5,0,3]
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
 * Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 *
 * Constraints:
 * 0 <= k <= 109
 * 0 <= prices.length <= 104
 * 0 <= prices[i] <= 1000
 */
public class Solution {
    // tc O(n*k), sc O(k), MLE
    public int maxProfit(int k, int[] prices) {
        if (k == 0) return 0;
        if (k >= prices.length / 2) return quickSolve(prices); // you can buy/sell on each day
        int[] cost = new int[k];
        Arrays.fill(cost, Integer.MAX_VALUE);
        int[] profit = new int[k];
        for (int price : prices) {
            for (int i = 0; i < k; i++) {
                cost[i] = Math.min(cost[i], i == 0 ? price : price - profit[i - 1]);
                profit[i] = Math.max(profit[i], price - cost[i]);
            }
        }
        return profit[k - 1];
    }

    private int quickSolve(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
