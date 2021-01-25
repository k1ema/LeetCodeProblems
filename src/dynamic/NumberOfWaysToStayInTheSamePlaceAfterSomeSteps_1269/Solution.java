package dynamic.NumberOfWaysToStayInTheSamePlaceAfterSomeSteps_1269;

/**
 * 1269. Number of Ways to Stay in the Same Place After Some Steps
 * https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/
 *
 * You have a pointer at index 0 in an array of size arrLen. At each step, you can move 1 position to the left, 1 position
 * to the right in the array or stay in the same place  (The pointer should not be placed outside the array at any time).
 *
 * Given two integers steps and arrLen, return the number of ways such that your pointer still at index 0 after exactly steps steps.
 *
 * Since the answer may be too large, return it modulo 10^9 + 7.
 *
 * Example 1:
 * Input: steps = 3, arrLen = 2
 * Output: 4
 * Explanation: There are 4 differents ways to stay at index 0 after 3 steps.
 * Right, Left, Stay
 * Stay, Right, Left
 * Right, Stay, Left
 * Stay, Stay, Stay
 *
 * Example 2:
 * Input: steps = 2, arrLen = 4
 * Output: 2
 * Explanation: There are 2 differents ways to stay at index 0 after 2 steps
 * Right, Left
 * Stay, Stay
 *
 * Example 3:
 * Input: steps = 4, arrLen = 2
 * Output: 8
 *
 * Constraints:
 * 1 <= steps <= 500
 * 1 <= arrLen <= 10^6
 */
public class Solution {
    // tc O(steps^2), sc O(steps^2)
    // 9 ms, faster than 88.28%; 43.1 MB, less than 28.71
    private final static int mod = (int) 1e9 + 7;
    public int numWays(int steps, int arrLen) {
        return helper(steps, arrLen, 0, new Integer[steps + 1][Math.min(steps, arrLen)]);
    }

    private int helper(int steps, int arrLen, int i, Integer[][] memo) {
        if (steps == 0) {
            return i == 0 ? 1 : 0;
        }
        if (i > steps) return 0;
        if (memo[steps][i] != null) {
            return memo[steps][i];
        }
        int res = helper(steps - 1, arrLen, i, memo) % mod;
        if (i > 0) {
            res = (res + helper(steps - 1, arrLen, i - 1, memo) % mod) % mod;
        }
        if (i < arrLen - 1) {
            res = (res + helper(steps - 1, arrLen, i + 1, memo) % mod) % mod;
        }
        memo[steps][i] = res;
        return res;
    }

    // tc O(steps^2), sc O(steps^2)
    // 17 ms, faster than 46.20%; 40.5 MB, less than 46.53%
    public int numWays1(int steps, int arrLen) {
        int mod = (int) 1e9 + 7;
        int maxPos = Math.min(steps, arrLen);
        long[][] dp = new long[steps + 1][maxPos + 1];
        dp[1][0] = 1;
        dp[1][1] = 1;
        for (int i = 2; i <= steps; i++) {
            for (int j = 0; j < maxPos; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 1][j + 1] + (j > 0 ? dp[i - 1][j - 1] : 0)) % mod;
            }
        }
        return (int) dp[steps][0] % mod;
    }
}
