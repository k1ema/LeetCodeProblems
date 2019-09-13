package dynamic.CoinChange_II_518;

/**
 * 518. Coin Change 2
 * https://leetcode.com/problems/coin-change-2/
 *
 * You are given coins of different denominations and a total amount of money. Write a function to
 * compute the number of combinations that make up that amount. You may assume that you have infinite
 * number of each kind of coin.
 *
 * Example 1:
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 * Example 2:
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 *
 * Example 3:
 * Input: amount = 10, coins = [10]
 * Output: 1
 */
public class Solution {
    // tc O(amount * coins.len); sc O(amount)
    // 3 ms, faster than 49.82%; 34.5 MB, less than 100.00%
    int change(int amount, int[] coins) {
        if (amount == 0) return 1;
        int[] dp = new int[amount + 1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i] == 0) {
                    dp[j] += 1;
                } else if (j - coins[i] > 0) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }
}
