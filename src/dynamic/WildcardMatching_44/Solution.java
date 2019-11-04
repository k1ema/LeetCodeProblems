package dynamic.WildcardMatching_44;

/**
 * 44. Wildcard Matching
 * https://leetcode.com/problems/wildcard-matching/
 *
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 *
 * Example 1:
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 * Example 2:
 * Input:
 * s = "aa"
 * p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 *
 * Example 3:
 * Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 *
 * Example 4:
 * Input:
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 *
 * Example 5:
 * Input:
 * s = "acdcb"
 * p = "a*c?b"
 * Output: false
 */
public class Solution {
    // tc O(m*n), sc O(m*n)
    // 11 ms, faster than 67.17%; 37.1 MB, less than 100.00%
    // https://www.geeksforgeeks.org/wildcard-pattern-matching/
    // https://www.youtube.com/watch?v=3ZDZ-N0EPV0
    // https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/WildCardMatching.java
    boolean isMatch(String s, String p) {
        if (s == null || p == null) throw new IllegalArgumentException();
        if (p.isEmpty()) return s.isEmpty();

        int m = s.length() + 1, n = p.length() + 1;
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        for (int i = 1; i < n; i++) {
            int charIndex = i - 1;
            dp[0][i] = dp[0][i - 1] & (p.charAt(charIndex) == '*');
        }

        for (int i = 1; i < m; i++) {
            int sInd = i - 1;
            for (int j = 1; j < n; j++) {
                int pInd = j - 1;
                if (s.charAt(sInd) == p.charAt(pInd) || p.charAt(pInd) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(pInd) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
