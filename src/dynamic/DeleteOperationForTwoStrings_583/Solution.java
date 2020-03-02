package dynamic.DeleteOperationForTwoStrings_583;

/**
 * 583. Delete Operation for Two Strings
 * https://leetcode.com/problems/delete-operation-for-two-strings/
 *
 * Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the
 * same, where in each step you can delete one character in either string.
 *
 * Example 1:
 * Input: "sea", "eat"
 * Output: 2
 *
 * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 *
 * Note:
 * The length of given words won't exceed 500.
 * Characters in given words can only be lower-case letters.
 */
public class Solution {
    // tc O(n*m), sc O(n*m)
    // 7 ms, faster than 80.76%; 41.3 MB, less than 11.76%
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) return 0;
        if (word1 == null || word1.isEmpty()) return word2.length();
        if (word2 == null || word2.isEmpty()) return word1.length();

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        return word1.length() + word2.length() - dp[word1.length()][word2.length()] * 2;
    }
}
