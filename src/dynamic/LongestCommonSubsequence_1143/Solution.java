package dynamic.LongestCommonSubsequence_1143;

/**
 * 1143. Longest Common Subsequence
 * https://leetcode.com/problems/longest-common-subsequence/
 *
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 *
 * A subsequence of a string is a new string generated from the original string with some
 * characters(can be none) deleted without changing the relative order of the remaining characters.
 * (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings
 * is a subsequence that is common to both strings.
 *
 * If there is no common subsequence, return 0.
 *
 * Example 1:
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 *
 * Example 2:
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 *
 * Example 3:
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *
 * Constraints:
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * The input strings consist of lowercase English characters only.
 */
public class Solution {
    /*
        Great explanation
        https://leetcode.com/articles/longest-common-subsequence/

        "abcde"
        "abc"
            a b c d e
          0 0 0 0 0 0
        a 0 1 1 1 1 1
        b 0 1 2 2 2 2
        c 0 1 2 3 3 3
    */
    // DP bottom-up aproach
    // tc O(mn), sc O(mn), where m = text1.length, n = text2.length
    // 10 ms, faster than 52.83%, 43.4 MB, less than 100.00%
    public int longestCommonSubsequence1(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            char c = text1.charAt(i);
            for (int j = 0; j < n; j++) {
                if (c == text2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        String s = getSubsequence(dp, text1);
        System.out.println(s);
        return dp[m][n];
    }

    private String getSubsequence(int[][] dp, String t1) {
        StringBuilder sb = new StringBuilder();
        int i = dp.length - 1, j = dp[0].length - 1;
        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i - 1][j] || dp[i][j] == dp[i][j - 1]) {
                if (dp[i][j] == dp[i - 1][j]) {
                    i--;
                } else {
                    j--;
                }
            } else {
                sb.append(t1.charAt(i - 1));
                i--; j--;
            }
        }
        return sb.reverse().toString();
    }

    // Backtracking with memoization, top-down approach
    // tc O(mn), sc O(mn)
    // 18 ms, faster than 16.60%; 44.2 MB, less than 100.00%
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                memo[i][j] = -1;
            }
        }
        return solve(text1, text2, 0, 0, memo);
    }

    private int solve(String text1, String text2, int p1, int p2, int[][] memo) {
        if (p1 == text1.length() || p2 == text2.length()) {
            return 0;
        }

        if (memo[p1][p2] != -1) return memo[p1][p2];

        if (text1.charAt(p1) == text2.charAt(p2)) {
            memo[p1][p2] = 1 + solve(text1, text2, p1 + 1, p2 + 1, memo);
        } else {
            memo[p1][p2] = Math.max(solve(text1, text2, p1 + 1, p2, memo), solve(text1, text2, p1, p2 + 1, memo));
        }

        return memo[p1][p2];
    }
}
