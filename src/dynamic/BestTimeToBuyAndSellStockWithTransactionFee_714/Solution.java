package dynamic.BestTimeToBuyAndSellStockWithTransactionFee_714;

/**
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day,
 * and an integer fee representing a transaction fee.
 *
 * Find the maximum profit you can achieve. You may complete as many transactions as you like,
 * but you need to pay the transaction fee for each transaction.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the
 * stock before you buy again).
 *
 * Example 1:
 * Input: prices = [1,3,2,8,4,9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * - Buying at prices[0] = 1
 * - Selling at prices[3] = 8
 * - Buying at prices[4] = 4
 * - Selling at prices[5] = 9
 * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 *
 * Example 2:
 * Input: prices = [1,3,7,5,10,3], fee = 3
 * Output: 6
 *
 * Constraints:
 * 1 < prices.length <= 5 * 10^4
 * 0 < prices[i], fee < 5 * 10^4
 */
public class Solution {
    /*
        x0 - cur profit and you do not have stock
        x1 - cur profit and you have stock

        on the next day:
        x0' = max(x0, x1 + p)
        x1' = max(x1, x0 - p - fee)
    */
    // tc O(n), sc O(1)
    public int maxProfit(int[] prices, int fee) {
        int x0 = 0, x1 = Integer.MIN_VALUE;
        for (int p : prices) {
            int x0_ = x0;
            x0 = Math.max(x0, x1 + p);
            x1 = Math.max(x1, x0_ - p - fee);
        }
        return Math.max(x0, x1);
    }

    // tc O(n * x), sc O(n)
    public int maxProfit1(int[] prices, int fee) {
        return f(prices, fee, 0, 0, new Integer[prices.length][2]);
    }

    private int f(int[] prices, int fee, int state, int idx, Integer[][] memo) {
        if (idx == prices.length) return 0;
        if (memo[idx][state] != null) return memo[idx][state];

        int res = f(prices, fee, state, idx + 1, memo);
        if (state == 0) {
            res = Math.max(res, f(prices, fee, state + 1, idx + 1, memo) - prices[idx]);
        } else {
            res = Math.max(res, f(prices, fee, (state + 1) % 2, idx + 1, memo) + prices[idx] - fee);
        }
        memo[idx][state] = res;
        return res;
    }
}
