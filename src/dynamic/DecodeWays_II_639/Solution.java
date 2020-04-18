package dynamic.DecodeWays_II_639;

import java.util.HashMap;
import java.util.Map;

/**
 * 639. Decode Ways II
 * https://leetcode.com/problems/decode-ways-ii/
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping way:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Beyond that, now the encoded string can also contain the character '*', which can be treated
 * as one of the numbers from 1 to 9.
 *
 * Given the encoded message containing digits and the character '*', return the total number of
 * ways to decode it.
 *
 * Also, since the answer may be very large, you should return the output mod 10^9 + 7.
 *
 * Example 1:
 * Input: "*"
 * Output: 9
 * Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".
 *
 * Example 2:
 * Input: "1*"
 * Output: 9 + 9 = 18
 *
 * Note:
 * The length of the input string will fit in range [1, 10^5].
 * The input string will only contain the character '*' and digits '0' - '9'.
 */

public class Solution {
    // tc O(n), sc O(n)
    // https://leetcode.com/articles/decode-ways-ii/ Approach 2: Dynamic Programming
    int M = 1000000007;
    public int numDecodings(String s) {
        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                dp[i + 1] = 9 * dp[i];
                if (s.charAt(i - 1) == '1')
                    dp[i + 1] = (dp[i + 1] + 9 * dp[i - 1]) % M;
                else if (s.charAt(i - 1) == '2')
                    dp[i + 1] = (dp[i + 1] + 6 * dp[i - 1]) % M;
                else if (s.charAt(i - 1) == '*')
                    dp[i + 1] = (dp[i + 1] + 15 * dp[i - 1]) % M;
            } else {
                dp[i + 1] = s.charAt(i) != '0' ? dp[i] : 0;
                if (s.charAt(i - 1) == '1')
                    dp[i + 1] = (dp[i + 1] + dp[i - 1]) % M;
                else if (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')
                    dp[i + 1] = (dp[i + 1] + dp[i - 1]) % M;
                else if (s.charAt(i - 1) == '*')
                    dp[i + 1] = (dp[i + 1] + (s.charAt(i) <= '6' ? 2 : 1) * dp[i - 1]) % M;
            }
        }
        return (int) dp[s.length()];
    }


    // my solution
    // 549 ms, faster than 5.02%; 222.7 MB, less than 7.14%
    private Map<Integer, Long> map;
    public int numDecodings1(String s) {
        map = new HashMap<>();
        return (int) (recursive(s, 0) % M);
    }

    private long recursive(String s, int ind) {
        if (ind == s.length()) return 1;
        if (s.charAt(ind) == '0') return 0;
        if (ind == s.length() - 1) return s.charAt(ind) == '*' ? 9 : 1;

        if (map.containsKey(ind)) return map.get(ind);

        long res = 0;
        if (s.charAt(ind) == '*') {
            long r = recursive(s, ind + 1);
            res += (9 * r) % M;
        } else {
            res = recursive(s, ind + 1) % M;
        }
        String substr = s.substring(ind, ind + 2);
        if (substr.contains("*")) {
            if (substr.equals("**")) { // 11, 12, ..., 19; 21, 22, ... 26. count = 9 + 6 = 15
                res += (15 * recursive(s, ind + 2)) % M;
            } else {
                if (substr.charAt(0) == '*') {
                    // pattern *_: *0..*9
                    int val = Integer.parseInt(s.substring(ind + 1, ind + 2));
                    for (int i = 1; i <= 2; i++) {
                        int x = i * 10 + val;
                        if (10 <= x && x <= 26) {
                            res += recursive(s, ind + 2) % M;
                        }
                    }
                } else {
                    // pattern _*: 1*..2*
                    int val = Integer.parseInt(s.substring(ind, ind + 1));
                    if (val == 1 || val == 2) {
                        for (int i = 1; i <= 9; i++) {
                            int x = val * 10 +  i;
                            if (10 <= x && x <= 26) {
                                res += recursive(s, ind + 2) % M;
                            }
                        }
                    }
                }
            }
        } else {
            int val = Integer.parseInt(substr);
            if (10 <= val && val <= 26) {
                res += recursive(s, ind + 2) % M;
            }
        }

        map.put(ind, res);

        return res;
    }
}
