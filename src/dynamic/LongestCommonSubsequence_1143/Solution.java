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
    // tc O(m*n), sc O(m*n), where m = text1.length, n = text2.length
    // 10 ms, faster than 52.83%, 43.4 MB, less than 100.00%
    int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        String s = getSubsequence(dp, text1);
        System.out.println(s);
        return dp[text1.length()][text2.length()];
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
}