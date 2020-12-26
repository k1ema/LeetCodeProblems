package dynamic.DecodeWays_91;

import java.util.HashMap;
import java.util.Map;

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
    // 1 ms, faster than 93.50%; 37.6 MB, less than 45.70%
    public int numDecodings1(String s) {
        return helper(s, 0, new HashMap<>());
    }

    private int helper(String s, int idx, Map<Integer, Integer> memo) {
        if (memo.containsKey(idx)) return memo.get(idx);
        if (idx == s.length()) return 1;
        if (s.charAt(idx) == '0') return 0;
        int res = helper(s, idx + 1, memo);
        if (idx < s.length() - 1) {
            int num = Integer.parseInt(s.substring(idx, idx + 2));
            if (num >= 10 && num <= 26) {
                res += helper(s, idx + 2, memo);
            }
        }
        memo.put(idx, res);
        return res;
    }
}
