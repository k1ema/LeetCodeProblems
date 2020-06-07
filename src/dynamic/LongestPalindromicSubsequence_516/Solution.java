package dynamic.LongestPalindromicSubsequence_516;

/**
 * 516. Longest Palindromic Subsequence
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 *
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the
 * maximum length of s is 1000.
 *
 * Example 1:
 * Input:
 * "bbbab"
 * Output:
 * 4
 * One possible longest palindromic subsequence is "bbbb".
 *
 * Example 2:
 * Input:
 * "cbbd"
 * Output:
 * 2
 * One possible longest palindromic subsequence is "bb".
 */
public class Solution {
    // bottom-up
    // tc O(n^2), sc O(n^2)
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.isEmpty()) return 0;
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    // top-down with memo
    // tc O(n), sc O(n^2)
    public int longestPalindromeSubseq1(String s) {
        int[][] memo = new int[s.length()][s.length()];
        return helper(s, 0, s.length() - 1, memo);
    }

    private int helper(String s, int i, int j, int[][] memo) {
        if (i > j) return 0;
        if (i == j) return 1;

        if (memo[i][j] != 0) return memo[i][j];
        int val;
        if (s.charAt(i) == s.charAt(j)) {
            val = 2 + helper(s, i + 1, j - 1, memo);
        } else {
            val = Math.max(helper(s, i + 1, j, memo), helper(s, i, j - 1, memo));
        }
        memo[i][j] = val;
        return val;
    }
}
