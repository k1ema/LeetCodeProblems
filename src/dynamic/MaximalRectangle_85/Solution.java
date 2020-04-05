package dynamic.MaximalRectangle_85;

import java.util.Arrays;

/**
 * 85. Maximal Rectangle
 * https://leetcode.com/problems/maximal-rectangle/
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing
 * only 1's and return its area.
 *
 * Example:
 * Input:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * Output: 6
 */
public class Solution {
    // good explanation
    // https://leetcode.com/problems/maximal-rectangle/discuss/29054/Share-my-DP-solution
    // https://leetcode.com/articles/maximal-rectangle/
    // tc O(mn), sc O(n) where m = number of rows, n - number of columns
    // 2 ms, faster than 99.53%; 43.4 MB, less than 80.43%
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int n = matrix[0].length;
        int maxA = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        Arrays.fill(right, n);
        for (int i = 0; i < matrix.length; i++) {
            int curLeft = 0, curRight = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], curLeft);
                } else {
                    curLeft = j + 1;
                    left[j] = 0;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], curRight);
                } else {
                    curRight = j;
                    right[j] = n;
                }
            }
            for (int j = 0; j < n; j++) {
                maxA = Math.max(maxA, (right[j] - left[j]) * height[j]);
            }
        }
        return maxA;
    }

    // tc O(m^2*n), sc O(mn) where m - number of rows, n - number of columns
    // https://leetcode.com/articles/maximal-rectangle/
    // see Approach 2: Dynamic Programming - Better Brute Force on Histograms
    public int maximalRectangle1(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int maxarea = 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    // compute the maximum width and update dp with it
                    dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;

                    int width = dp[i][j];

                    // compute the maximum area rectangle with a lower right corner at [i, j]
                    for (int k = i; k >= 0; k--) {
                        width = Math.min(width, dp[k][j]);
                        maxarea = Math.max(maxarea, width * (i - k + 1));
                    }
                }
            }
        }
        return maxarea;
    }
}
