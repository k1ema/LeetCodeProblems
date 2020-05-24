package dynamic.MinimumPathSum_64;

/**
 * 64. Minimum Path Sum
 * https://leetcode.com/problems/minimum-path-sum/
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom
 * right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class Solution {
    // tc O(m * n), sc O(m * n)
    // 2 ms, faster than 87.91%; 41.8 MB, less than 87.84%
    int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = grid[i][j];
                if (i > 0 && j > 0) {
                    dp[i][j] += Math.min(dp[i - 1][j], dp[i][j - 1]);
                } else if (i != 0 || j != 0) {
                    if (i == 0) dp[i][j] += dp[i][j - 1];
                    else dp[i][j] += dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    // tc O(n), sc O(n), n - number of columns
    // 1 ms, faster than 99.48%; 42 MB, less than 87.84%
    int minPathSum1(int[][] grid) {
        int n;
        if (grid == null || grid.length == 0 || (n = grid[0].length) == 0) return 0;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[j] += grid[i][j];
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
                }
            }
        }
        return dp[n - 1];
    }
}
