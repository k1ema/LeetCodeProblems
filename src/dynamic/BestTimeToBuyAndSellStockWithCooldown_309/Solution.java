package dynamic.BestTimeToBuyAndSellStockWithCooldown_309;

/**
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you
 * like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 *
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 *
 * Example:
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */
public class Solution {
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75931/Easiest-JAVA-solution-with-explanations
    // tc O(n), sc O(1)
    /*
        buy[i] = max(buy[i - 1], sell[i - 2] - prices[i])
        sell[i] = max(sell[i - 1], buy[i - 1] + prices[i])

             0  1  2  3  4
            --------------
   prices[]  1  2  3  0  2
      buy[] -1 -1 -1  1  1
     sell[]  0  1  2  2  3

     b0 = -prices[0], b1 = b0
     s0 = s1 = s2 = 0
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) return 0;
        int b0 = -prices[0], b1 = b0;
        int s0 = 0, s1 = 0, s2 = 0;
        for (int i = 1; i < prices.length; i++) {
            b0 = Math.max(b1, s2 - prices[i]);
            s0 = Math.max(s1, b1 + prices[i]);
            s2 = s1; s1 = s0; b1 = b0;
        }
        return s0;
    }

    // 2 ms, faster than 16.04%; 39.7 MB, less than 5.35%
    public int maxProfit1(int[] prices) {
        return helper(prices, 0, 0, 0, new Integer[prices.length][2][2]);
    }

    private int helper(int[] prices, int i, int cooldown, int state, Integer[][][] memo) {
        if (i == prices.length) return 0;
        if (memo[i][cooldown][state] != null) {
            return memo[i][cooldown][state];
        }
        int res = helper(prices, i + 1, Math.max(0, cooldown - 1), state, memo);
        if (state == 0) {
            if (cooldown == 0) {
                res = Math.max(res, -prices[i] + helper(prices, i + 1, cooldown, 1, memo));
            }
        } else {
            res = Math.max(res, prices[i] + helper(prices, i + 1, 1, 0, memo));
        }
        return memo[i][cooldown][state] = res;
    }

    /*
        https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75928/Share-my-DP-solution-(By-State-Machine-Thinking)

        '*' means it is possible to stay at same state

                buy
        reset* -----> held*
             ^      /
         rest \    / sell
               \  /
                 v
               sold

        sold[i] = held[i - 1] + price[i]
        held[i] = max(held[i - 1], reset[i - 1] - price[i])
        reset[i] = max(reset[i - 1], sold[i - 1])
     */
    // tc O(n), sc O(1)
    // 0 ms, faster than 100.00%; 37.8 MB, less than 13.69%
    public int maxProfit2(int[] prices) {
        int sold = Integer.MIN_VALUE, held = Integer.MIN_VALUE, reset = 0;
        for (int price : prices) {
            int preSold = sold;
            sold = held + price;
            held = Math.max(held, reset - price);
            reset = Math.max(reset, preSold);
        }
        return Math.max(sold, reset);
    }
}
