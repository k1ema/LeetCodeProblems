package dynamic.CoinChange_322;

import java.util.Arrays;

/**
 * 322. Coin Change
 * https://leetcode.com/problems/coin-change/
 *
 * You are given coins of different denominations and a total amount of money amount. Write a function to
 * compute the fewest number of coins that you need to make up that amount. If that amount of money cannot
 * be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * Example 1:
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 * Example 3:
 * Input: coins = [1], amount = 0
 * Output: 0
 *
 * Example 4:
 * Input: coins = [1], amount = 1
 * Output: 1
 *
 * Example 5:
 * Input: coins = [1], amount = 2
 * Output: 2
 *
 * Constraints:
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 23^1 - 1
 * 0 <= amount <= 10^4
 */
public class Solution {
    // tc O(n * amount), sc O(amount), bottom-up
    /*
           0 1 2 3 4 5 6 7 8 9 10 11
        1  0 1 2 3 4 5 6 7 8 9 10 11
        2  0 1 1 2 2 3 3 4 4 5  5  6
        5  0 1 1 2 2 1 2
    */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[amount] == 10001 ? -1 : dp[amount];
    }

    // tc O(n * amount), sc O(amount), top-down
    public int coinChange1(int[] coins, int amount) {
        Arrays.sort(coins);
        int res = helper(coins, amount, new Integer[amount + 1]);
        return res == 10001 ? -1 : res;
    }

    private int helper(int[] coins, int amount, Integer[] memo) {
        if (amount == 0) return 0;
        if (memo[amount] != null) return memo[amount];
        int count = 10001;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (amount - coins[i] >= 0) {
                count = Math.min(count, 1 + helper(coins, amount - coins[i], memo));
            }
        }
        memo[amount] = count;
        return count;
    }
}
