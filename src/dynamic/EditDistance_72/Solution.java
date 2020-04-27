package dynamic.EditDistance_72;

/**
 * 72. Edit Distance
 * https://leetcode.com/problems/edit-distance/
 *
 * Given two words word1 and word2, find the minimum number of operations required
 * to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 * Insert a character
 * Delete a character
 * Replace a character
 *
 * Example 1:
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 *
 * Example 2:
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 */
public class Solution {
    // DP
    // tc O(mn), sc O(mn)
    // 10 ms, faster than 11.77%; 41.9 MB, less than 5.88%
    // https://leetcode.com/problems/edit-distance/discuss/25895/Step-by-step-explanation-of-how-to-optimize-the-solution-from-simple-recursion-to-DP
    /*
          h o r s e
        0 1 2 3 4 5
      r 1 1 2 2 3 4
      o 2 2 1 2 3 4
      s 3 3 2 2 2 3
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return -1;
        int m = word1.length(), n = word2.length();
        if (m == 0) return n;
        if (n == 0) return m;

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = 1 + Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j]);
                }
            }
        }

        return dp[m][n];
    }

    // Backtracking approach with memoization
    // tc O(mn), sc O(mn)
    // 4 ms, faster than 94.20%; 40.3 MB, less than 5.88%
    // https://leetcode.com/problems/edit-distance/discuss/25895/Step-by-step-explanation-of-how-to-optimize-the-solution-from-simple-recursion-to-DP
    public int minDistance1(String word1, String word2) {
        if (word1 == null || word2 == null) return -1;
        int m = word1.length(), n = word2.length();
        if (m == 0) return n;
        if (n == 0) return m;

        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        return bt(word1, word2, 0, 0, memo);
    }

    private int bt(String word1, String word2, int p1, int p2, int[][] memo) {
        if (p1 == word1.length()) {
            return word2.length() - p2;
        }
        if (p2 == word2.length()) {
            return word1.length() - p1;
        }

        if (memo[p1][p2] != -1) {
            return memo[p1][p2];
        }

        int num;
        if (word1.charAt(p1) != word2.charAt(p2)) {
            int insert = bt(word1, word2, p1, p2 + 1, memo);
            int delete = bt(word1, word2, p1 + 1, p2, memo);
            int replace = bt(word1, word2, p1 + 1, p2 + 1, memo);
            num = 1 + Math.min(Math.min(insert, delete), replace);
        } else {
            num = bt(word1, word2, p1 + 1, p2 + 1, memo);
        }

        memo[p1][p2] = num;
        return memo[p1][p2];
    }
}
