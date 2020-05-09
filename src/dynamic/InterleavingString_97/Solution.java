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
        int m = s1.length();
        int n = s2.length();
        if (s3.length() != m + n) return false;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        return bt(s1, s2, s3, 0, 0, 0, memo);
    }

    private boolean bt(String s1, String s2, String s3, int i, int j, int k, int[][] memo) {
        if (i == s1.length()) return s3.substring(k).equals(s2.substring(j));
        if (j == s2.length()) return s3.substring(k).equals(s1.substring(i));

        if (memo[i][j] >= 0) return memo[i][j] == 1;

        boolean res = (s3.charAt(k) == s1.charAt(i)) && bt(s1, s2, s3, i + 1, j, k + 1, memo)
                || (s3.charAt(k) == s2.charAt(j)) && bt(s1, s2, s3, i, j + 1, k + 1, memo);

        memo[i][j] = res ? 1 : 0;

        return res;
    }
}
