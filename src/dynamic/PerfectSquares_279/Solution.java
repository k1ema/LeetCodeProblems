package dynamic.PerfectSquares_279;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 279. Perfect Squares
 * https://leetcode.com/problems/perfect-squares/
 *
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Example 1:
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 *
 * Example 2:
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
public class Solution {
    // tc O(n * sqrt(n)), sc O(n)
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        List<Integer> perfectList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (isSquare(i)) {
                dp[i] = 1;
                perfectList.add(i);
            } else {
                for (int lastPerfect : perfectList) {
                    dp[i] = Math.min(dp[i], dp[i - lastPerfect] + 1);
                }
            }
        }
        return dp[n];
    }

    private boolean isSquare(int n) {
        double val = Math.sqrt(n);
        return val - (int) val == 0;
    }
}
