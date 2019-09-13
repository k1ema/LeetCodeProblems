package dynamic.CoinChange_322;

import java.util.Arrays;

/**
 * 322. Coin Change
 * https://leetcode.com/problems/coin-change/
 *
 * You are given coins of different denominations and a total amount of money amount. Write a function
 * to compute the fewest number of coins that you need to make up that amount. If that amount of money
 * cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class Solution {
    // tc O(n * amount), sc O(amount)
    // 8 ms, faster than 92.61%; 35.7 MB, less than 98.82%
    // https://leetcode.com/problems/coin-change/discuss/77360/c-onamount-time-oamount-space-dp-solution
    int coinChange(int[] coins, int amount) {
        // dp[i] is holding the min coins that consist number i
        int[] dp = new int[amount + 1];
        // set all values to amount + 1 as impossible value
        Arrays.fill(dp, amount + 1);
        // no money - no coin
        dp[0] = 0;
        // for example, coins = {1, 2, 5}, amount = 11
        // in the 1st round of iteration, coin is 1. so dp[i] = i.
        // in the 2nd round dp[2] will be replaced from 2 '1's to 1 '2's; dp[4]: from 4 '1's to 2 '2's etc.
        // in the 5th round dp[5] will be replaced from 3 (as 2 + 2 + 1) to 1.
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i] >= 0) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        // dp[amount] is the min coins for consisting the amount
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
