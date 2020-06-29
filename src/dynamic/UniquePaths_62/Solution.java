package dynamic.UniquePaths_62;

/**
 * 62. Unique Paths
 * https://leetcode.com/problems/unique-paths/
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach
 * the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 * Input: m = 3, n = 2
 * Output: 3
 *
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 *
 * Example 2:
 * Input: m = 7, n = 3
 * Output: 28
 */
public class Solution {
    // tc O(m * n), sc O(m * n)
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    // tc O(m * n), sc O(n)
    // https://leetcode.com/problems/unique-paths/discuss/22954/C%2B%2B-DP
    public int uniquePaths1(int m, int n) {
        if (m == 0 || n == 0) return 0;

        int[] cur = new int[n];
        for (int i = 0; i < n; i++) {
            cur[i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }

    // also could be computed as (m + n - 2)! / ((m - 1)!*(n - 1)!)
    // The problem is a classical combinatorial problem: there are h + v moves to do from start to finish,
    // h = m − 1 horizontal moves, and v = n - 1 vertical ones. We're asked to compute in how many ways one
    // could choose p elements from p + k elements. In mathematics, that's called binomial coefficients C(n,k) = n! / ((n-k)!k!)
}
