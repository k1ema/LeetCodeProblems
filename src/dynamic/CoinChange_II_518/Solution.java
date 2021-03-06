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
    // tc O(m * n), sc O(m * n)
    // where m = coins.length, n = amount
    // 17 ms, faster than 17.39%; 44.1 MB, less than 37.99%
    public int change(int amount, int[] coins) {
        return helper(coins, amount, 0, new Integer[coins.length + 1][amount + 1]);
    }

    private int helper(int[] coins, int amount, int ind, Integer[][] memo) {
        if (amount == 0) return 1;
        if (ind == coins.length || amount < 0) return 0;
        if (memo[ind][amount] != null) return memo[ind][amount];
        int res = helper(coins, amount - coins[ind], ind, memo);
        res += helper(coins, amount, ind + 1, memo);
        memo[ind][amount] = res;
        return res;
    }

    /*
        0 1 2 3 4 5
      1 1 1 1 1 1 1
      2 1 1 2 2 3 3
      5 1 1 2 2 3 4

        0 1 2 3
      2 1 0 1 0

        init dp array : new int[amount + 1]
        dp[0] = 1
        for i : amount
            for j : coins
                if j >= coins[i] dp[j] += dp[j - coins[i]]
    */

    // tc O(m * n), sc O(m), where m = amount, n = coins.length
    // 2 ms, faster than 100.00%; 36.7 MB, less than 92.02%
    // same as #377 Combination Sum IV but different iteration order. Here we find only 1 permutation inside combination
    public int change1(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
