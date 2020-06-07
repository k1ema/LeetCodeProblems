package dynamic.ValidPalindrome_III_1216;

/**
 * 1216. Valid Palindrome III
 * https://leetcode.com/problems/valid-palindrome-iii/
 *
 * Given a string s and an integer k, find out if the given string is a K-Palindrome or not.
 *
 * A string is K-Palindrome if it can be transformed into a palindrome by removing at most k characters from it.
 *
 * Example 1:
 * Input: s = "abcdeca", k = 2
 * Output: true
 * Explanation: Remove 'b' and 'e' characters.
 *
 * Constraints:
 * 1 <= s.length <= 1000
 * s has only lowercase English letters.
 * 1 <= k <= s.length
 */
public class Solution {
    // same as 516. Longest Palindromic Subsequence

    // bottom-up
    // tc O(n), sc O(n^2)
    // 11 ms, faster than 52.56%; 40.7 MB, less than 90.22%
    public boolean isValidPalindrome(String s, int k) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1] <= k;
    }

    // top-bottom
    // tc O(n), sc O(n^2)
    // 10 ms, faster than 79.01%; 41.1 MB, less than 48.16%
    public boolean isValidPalindrome1(String s, int k) {
        Integer[][] memo = new Integer[s.length()][s.length()];
        return helper(s, 0, s.length() - 1, memo) <= k;
    }

    private int helper(String s, int i, int j, Integer[][] memo) {
        if (i >= j) return 0;

        if (memo[i][j] != null) return memo[i][j];
        int val;
        if (s.charAt(i) == s.charAt(j)) {
            val = helper(s, i + 1, j - 1, memo);
        } else {
            val = 1 + Math.min(helper(s, i + 1, j, memo), helper(s, i, j - 1, memo));
        }
        memo[i][j] = val;
        return val;
    }
}
