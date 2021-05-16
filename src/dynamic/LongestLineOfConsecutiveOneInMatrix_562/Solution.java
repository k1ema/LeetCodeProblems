package dynamic.LongestLineOfConsecutiveOneInMatrix_562;

/**
 * 562. Longest Line of Consecutive One in Matrix
 * https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/
 *
 * Given an m x n binary matrix mat, return the length of the longest line of consecutive one in the matrix.
 *
 * The line could be horizontal, vertical, diagonal, or anti-diagonal.
 *
 * Example 1:
 * Input: mat = [[0,1,1,0],
 *               [0,1,1,0],
 *               [0,0,0,1]]
 * Output: 3
 *
 * Example 2:
 * Input: mat = [[1,1,1,1],
 *               [0,1,1,0],
 *               [0,0,0,1]]
 * Output: 4
 *
 * Constraints:
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 10^4
 * 1 <= m * n <= 10^4
 * mat[i][j] is either 0 or 1.
 */
public class Solution {
    public int longestLine(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][][] dp = new int[m][n][4];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) continue;
                dp[i][j][0] = (i > 0 ? dp[i-1][j][0] : 0) + 1;
                dp[i][j][1] = (j > 0 ? dp[i][j-1][1] : 0) + 1;
                dp[i][j][2] = (i > 0 && j > 0 ? dp[i-1][j-1][2] : 0) + 1;
                dp[i][j][3] = (i > 0 && j < n - 1 ? dp[i-1][j+1][3] : 0) + 1;
                for (int k = 0; k < 4; k++) {
                    res = Math.max(res, dp[i][j][k]);
                }
            }
        }
        return res;
    }
}
