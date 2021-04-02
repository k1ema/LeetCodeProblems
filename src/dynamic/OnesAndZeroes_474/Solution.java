package dynamic.OnesAndZeroes_474;

/**
 * 474. Ones and Zeroes
 * https://leetcode.com/problems/ones-and-zeroes/
 *
 * You are given an array of binary strings strs and two integers m and n.
 *
 * Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.
 *
 * A set x is a subset of a set y if all elements of x are also elements of y.
 *
 * Example 1:
 * Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
 * Output: 4
 * Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
 * Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
 * {"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.
 *
 * Example 2:
 * Input: strs = ["10","0","1"], m = 1, n = 1
 * Output: 2
 * Explanation: The largest subset is {"0", "1"}, so the answer is 2.
 *
 * Constraints:
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] consists only of digits '0' and '1'.
 * 1 <= m, n <= 100
 */
public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        return dp(strs, 0, m, n, new Integer[strs.length][m + 1][n + 1]);
    }

    private int dp(String[] strs, int i, int m, int n, Integer[][][] memo) {
        if (i == strs.length || m == 0 && n == 0) return 0;
        if (memo[i][m][n] != null) return memo[i][m][n];
        int zeroes = 0, ones = 0;
        for (int j = 0; j < strs[i].length(); j++) {
            if (strs[i].charAt(j) == '0') {
                zeroes++;
            } else {
                ones++;
            }
        }
        int res = dp(strs, i + 1, m, n, memo);
        if (m - zeroes >= 0 && n - ones >= 0) {
            res = Math.max(res, 1 + dp(strs, i + 1, m - zeroes, n - ones, memo));
        }
        memo[i][m][n] = res;
        return res;
    }
}