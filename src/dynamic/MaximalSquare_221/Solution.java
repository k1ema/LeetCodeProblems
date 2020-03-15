package dynamic.MaximalSquare_221;

/**
 * 221. Maximal Square
 * https://leetcode.com/problems/maximal-square/
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only
 * 1's and return its area.
 *
 * Example:
 *
 * Input:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 */
public class Solution {
    // tc O(mn), sc O(mn)
    // 3 ms, faster than 98.09%; 43.5 MB, less than 91.18%
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;

        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

    // tc O(mn), sc O(n)
    // 3 ms, faster than 98.09%; 43.4 MB, less than 91.18%
    public int maximalSquare1(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;

        int[] dp = new int[n + 1];
        int max = 0, prev = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], dp[j]), prev) + 1;
                    max = Math.max(max, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return max * max;
    }
}
