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
    // tc O(n^2), sc O(n^2)
    // 43 ms, faster than 28.04%; 53.4 MB, less than 5.55%
    int longestPalindromeSubseq(String s) {
        if (s == null || s.isEmpty()) return 0;

        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        for (int l = 2; l <= s.length(); l++) {
            for (int i = 0; i + l - 1 < s.length(); i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }

        return dp[0][s.length() - 1];
    }
}
