package dynamic.InterleavingString_97;

/**
 * 97. Interleaving String
 * https://leetcode.com/problems/interleaving-string/
 *
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * Example 1:
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 *
 * Example 2:
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 */
public class Solution {
    /*
        v
        a a d b b c b c a c
        0 1 2 3 4 5 6 7 8 9

          0 1 2 3 4 5
          - d b b c a
      0 - 1 0 0 0 0 0
      1 a 1 0 0 0 0 0
      2 a 1 1 1 1 1 0
      3 b 0 1 1 0 1 0
      4 c 0 0 1 1 1 1
      5 c 0 0 0 1 0 1

     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (s3.length() != m + n) return false;
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1);
                } else {
                    dp[i][j] = dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1)
                            || dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1);
                }
            }
        }
        return dp[m][n];
    }

    // BT approach
    // tc O(m*n), sc O(m*n)
    // without memo tc O(2^(m+n)), sc O(m*n)
    public boolean isInterleave1(String s1, String s2, String s3) {
        return isInterleave(s1, s2, s3, 0, 0, 0, new Boolean[s1.length() + 1][s2.length() + 1]);
    }

    private boolean isInterleave(String s1, String s2, String s3, int i, int j, int k, Boolean[][] memo) {
        if (i == s1.length() && j == s2.length() && k == s3.length()) {
            return true;
        }
        if (k == s3.length()) {
            return false;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        boolean res = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            res = isInterleave(s1, s2, s3, i + 1, j, k + 1, memo);
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            res |= isInterleave(s1, s2, s3, i, j + 1, k + 1, memo);
        }
        memo[i][j] = res;
        return res;
    }
}
