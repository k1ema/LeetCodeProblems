package dynamic.RegularExpressionMatching_10;

/**
 * 10. Regular Expression Matching
 * https://leetcode.com/problems/regular-expression-matching/
 *
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
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
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once,
 * it becomes "aa".
 *
 * Example 3:
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 *
 * Example 4:
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
 *
 * Example 5:
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 */
public class Solution {
    // tc O(m*n), sc O(m*n)
    // 2 ms, faster than 96.43%; 36.3 MB, less than 100.00%
    // made it by myself but here is good explanation
    // https://www.youtube.com/watch?v=l3hda49XcDE&list=PLrmLmBdmIlpuE5GEMDXWf0PWbBD9Ga1lO
    // Here are some conditions to figure out, then the logic can be very straightforward.
    // 1. First row in matrix means empty string corresponds the pattern. Build a first row using rule
    //     dp[0][0] = true; if (p.charAt(charInd) == '*' && dp[0][i - 2]) dp[0][i] = true;
    // 2. If p.charAt(j) == s.charAt(i) or p.charAt(j) == '.' :  dp[i][j] = dp[i-1][j-1];
    // 3. If p.charAt(j) == '*':
    //               1 dp[i][j] = dp[i][j-2]  // in this case, a* only counts as empty
    //               2 if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
    //                         dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
    boolean isMatch(String s, String p) {
        if (s == null || p == null) throw new IllegalArgumentException();
        if (p.isEmpty()) return s.isEmpty();

        int m = s.length() + 1, n = p.length() + 1;
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        for (int i = 2; i < n; i++) {
            int charIndex = i - 1;
            if (p.charAt(charIndex) == '*' && dp[0][i - 2]) dp[0][i] = true;
        }

        for (int i = 1; i < m; i++) {
            int sInd = i - 1;
            for (int j = 1; j < n; j++) {
                int pInd = j - 1;
                if (s.charAt(sInd) == p.charAt(pInd) || p.charAt(pInd) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(pInd) == '*') {
                    // it works but code below is simpler
//                    dp[i][j] = dp[i][j - 1]; // a* counts as single a
//                    if (pInd > 0 && (s.charAt(sInd) == p.charAt(pInd - 1) || p.charAt(pInd - 1) == '.')) {
//                        dp[i][j] |= dp[i - 1][j]; // a* counts as multiple a
//                    }
//                    if (j > 1) {
//                        dp[i][j] |= dp[i][j - 2]; // a* counts as empty
//                    }
                    dp[i][j] = dp[i][j - 2]; // a* counts as empty
                    if (pInd > 0 && (s.charAt(sInd) == p.charAt(pInd - 1) || p.charAt(pInd - 1) == '.')) {
                        dp[i][j] |= dp[i - 1][j]; // a* counts as single or multiple a
                    }
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
