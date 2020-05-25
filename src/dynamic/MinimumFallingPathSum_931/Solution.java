package dynamic.MinimumFallingPathSum_931;

import java.util.stream.IntStream;

/**
 * 931. Minimum Falling Path Sum
 * https://leetcode.com/problems/minimum-falling-path-sum/
 *
 * Given a square array of integers A, we want the minimum sum of a falling path through A.
 *
 * A falling path starts at any element in the first row, and chooses one element from each row.
 * The next row's choice must be in a column that is different from the previous row's column by at most one.
 *
 * Example 1:
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: 12
 *
 * Explanation:
 * The possible falling paths are:
 * [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
 * [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
 * [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
 * The falling path with the smallest sum is [1,4,7], so the answer is 12.
 *
 * Note:
 * 1 <= A.length == A[0].length <= 100
 * -100 <= A[i][j] <= 100
 */
public class Solution {
    // tc O(m * n), sc O(m * n)
    public int minFallingPathSum2(int[][] A) {
        int m = A.length, n = A[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = A[i][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + A[i][j];
                    if (j > 0) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + A[i][j]);
                    if (j < n - 1) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j + 1] + A[i][j]);
                }
            }
        }
        return IntStream.of(dp[m - 1]).min().getAsInt();
    }

    // inplace dp: tc O(m * n), sc O(1)
    // https://leetcode.com/problems/minimum-falling-path-sum/discuss/186666/C%2B%2BJava-4-lines-DP
    public int minFallingPathSum1(int[][] A) {
        int m = A.length, n = A[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] += Math.min(A[i - 1][j], Math.min(A[i - 1][Math.max(0, j - 1)], A[i - 1][Math.min(n - 1, j + 1)]));
            }
        }
        return IntStream.of(A[m - 1]).min().getAsInt();
    }

    // backtracking with memoization, tc O(m * n), sc O(m * n)
    // w/o memo exponential tc O(n * (3 ^ m)) ??, TLE
    private int[][] memo;
    public int minFallingPathSum(int[][] A) {
        int m = A.length, n = A[0].length;
        if (m == 1) return IntStream.of(A[0]).min().getAsInt();
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = 101;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            res = Math.min(res, bt(A, m, n, 0, j));
        }
        return res;
    }

    private int bt(int[][] A, int m, int n, int i, int j) {
        if (i == m - 1) {
            return A[i][j];
        }
        if (memo[i][j] != 101) return memo[i][j];
        int curVal = A[i][j];
        int minPath = bt(A, m, n, i + 1, j) + curVal;
        if (j - 1 >= 0) minPath = Math.min(minPath, bt(A, m, n, i + 1, j - 1) + curVal);
        if (j + 1 < n) minPath = Math.min(minPath, bt(A, m, n, i + 1, j + 1) + curVal);
        memo[i][j] = minPath;
        return minPath;
    }
}
