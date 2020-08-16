package dynamic.BestTimeToBuyAndSellStock_III_123;

/**
 * 123. Best Time to Buy and Sell Stock III
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell
 * the stock before you buy again).
 *
 * Example 1:
 * Input: [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 *              Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * Example 2:
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class Solution {
    // tc O(n), sc O(1)
    // 2 ms, faster than 92.01%; 39.2 MB, less than 87.56%
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int t1Cost = Integer.MAX_VALUE, t2Cost = Integer.MAX_VALUE;
        int t1Profit = 0, t2Profit = 0;
        for (int price : prices) {
            t1Cost = Math.min(t1Cost, price);
            t1Profit = Math.max(t1Profit, price - t1Cost);
            t2Cost = Math.min(t2Cost, price - t1Profit);
            t2Profit = Math.max(t2Profit, price - t2Cost);
        }
        return t2Profit;
    }

    // tc O(n), sc O(n)
    // 2 ms, faster than 92.01%; 39.4 MB, less than 73.05%
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int[] leftProfits = new int[n];
        int[] rightProfits = new int[n];
        int minPrice = prices[0];
        int maxPrice = prices[n - 1];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            leftProfits[i] = Math.max(leftProfits[i - 1], prices[i] - minPrice);
        }
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            rightProfits[i] = Math.max(rightProfits[i + 1], maxPrice - prices[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int prevLeft = i > 0 ? leftProfits[i - 1] : 0;
            int nextRight = i < n - 1 ? rightProfits[i + 1] : 0;
            res = Math.max(res, Math.max(prevLeft + rightProfits[i], leftProfits[i] + nextRight));
        }
        return res;
    }

    // tc O(n^2), sc O(n)
    // 515 ms, 39.2 MB
    // the idea is the same as in 121. Best Time to Buy and Sell Stock: divide array into two parts
    // and then enumerate each of the subsequences
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int maxProfit1 = 0, maxProfit2 = 0;
            int minPrice = prices[0];
            for (int j = 1; j < i; j++) {
                if (prices[j] > minPrice) {
                    maxProfit1 = Math.max(maxProfit1, prices[j] - minPrice);
                } else {
                    minPrice = prices[j];
                }
            }
            minPrice = prices[i];
            for (int j = i + 1; j < n; j++) {
                if (prices[j] > minPrice) {
                    maxProfit2 = Math.max(maxProfit2, prices[j] - minPrice);
                } else {
                    minPrice = prices[j];
                }
            }
            res = Math.max(res, maxProfit1 + maxProfit2);
        }
        return res;
    }

    // tc O(n^4), sc O(1), TLE
    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prices[j] > prices[i]) {
                    for (int k = j + 1; k < n; k++) {
                        for (int l = k + 1; l < n; l++) {
                            if (prices[l] > prices[k]) {
                                res = Math.max(res, prices[j] - prices[i] + prices[l] - prices[k]);
                            }
                        }
                    }
                    res = Math.max(res, prices[j] - prices[i]);
                }
            }
        }
        return res;
    }

    // tc O(n^4), sc O(1), TLE
    // same idea but recursive approach
    public int maxProfit4(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        return bt(prices, 0, false);
    }

    private int bt(int[] prices, int start, boolean firstTransExist) {
        if (start == prices.length) return 0;
        int res = 0;
        for (int i = start; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    int dif = prices[j] - prices[i];
                    if (firstTransExist) {
                        res = Math.max(res, dif);
                    } else {
                        res = Math.max(res, Math.max(dif, dif + bt(prices, j + 1, true)));
                    }
                }
            }
        }
        return res;
    }
}
