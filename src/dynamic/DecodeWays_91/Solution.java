package dynamic.DecodeWays_91;

/**
 * 91. Decode Ways
 * https://leetcode.com/problems/decode-ways/
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 *
 * Example 2:
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class Solution {
    // bottom-up approach
    // tc O(n), sc O(n)
    // 1 ms, faster than 93.50%; 37.9 MB, less than 20.13%
    // https://leetcode.com/problems/decode-ways/discuss/30358/Java-clean-DP-solution-with-explanation
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            if (s.charAt(i - 1) > '0') dp[i] = dp[i - 1];
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    // top-down approach with memoization - same as finding Fibonacci number
    // tc O(n), sc O(n)
    // 0 ms, faster than 100.00%; 37.2 MB, less than 83.10%
    public int numDecodings1(String s) {
        return decodeWays(s, 0, new Integer[s.length()]);
    }

    private int decodeWays(String s, int i, Integer[] memo) {
        if (i == s.length()) return 1;
        if (memo[i] != null) return memo[i];
        int one_digit = s.charAt(i) - '0';
        if (one_digit == 0) return 0;
        int res = decodeWays(s, i + 1, memo);
        if (i < s.length() - 1) {
            int two_digits = one_digit * 10 + (s.charAt(i + 1) - '0');
            if (two_digits <= 26) {
                res += decodeWays(s, i + 2, memo);
            }
        }
        return memo[i] = res;
    }
}
