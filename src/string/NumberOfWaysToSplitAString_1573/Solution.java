package string.NumberOfWaysToSplitAString_1573;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1573. Number of Ways to Split a String
 * https://leetcode.com/problems/number-of-ways-to-split-a-string/
 *
 * Given a binary string s (a string consisting only of '0's and '1's), we can split s
 * into 3 non-empty strings s1, s2, s3 (s1+ s2+ s3 = s).
 *
 * Return the number of ways s can be split such that the number of characters '1' is
 * the same in s1, s2, and s3.
 *
 * Since the answer may be too large, return it modulo 10^9 + 7.
 *
 * Example 1:
 * Input: s = "10101"
 * Output: 4
 *
 * Explanation: There are four ways to split s in 3 parts where each part contain the
 * same number of letters '1'.
 * "1|010|1"
 * "1|01|01"
 * "10|10|1"
 * "10|1|01"
 *
 * Example 2:
 * Input: s = "1001"
 * Output: 0
 *
 * Example 3:
 * Input: s = "0000"
 * Output: 3
 * Explanation: There are three ways to split s in 3 parts.
 * "0|0|00"
 * "0|00|0"
 * "00|0|0"
 *
 * Example 4:
 * Input: s = "100100010100110"
 * Output: 12
 *
 * Constraints:
 * s[i] == '0' or s[i] == '1'
 * 3 <= s.length <= 10^5
 */
public class Solution {
    /*
           s = "1001|0|0|0|101|0|0|110"
        ones = {0,3,7,9,12,13}
         res = 4 options * 3 options
         if all zeroes -> res = C(n,k) = C(n - 1, 2) = (n-1) * (n-2) / 2
     */
    // https://leetcode.com/problems/number-of-ways-to-split-a-string/discuss/830536/Python-or-One-pass-or-Explained-and-Visualised
    // tc O(n), sc O(n)
    // 6 ms, faster than 71.43%; 40.2 MB, less than 57.14%
    public int numWays(String s) {
        int mod = (int) Math.pow(10, 9) + 7;
        int n = s.length();
        List<Integer> ones = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                cnt++;
                ones.add(i);
            }
        }
        if (cnt == 0) return (int) ((n - 1L) * (n - 2) / 2 % mod);
        if (cnt % 3 != 0) return 0;
        cnt /= 3;
        long a = ones.get(cnt) - ones.get(cnt - 1);
        long b = ones.get(2 * cnt) - ones.get(2 * cnt - 1);
        return (int) ((a * b) % mod);
    }

    // tc O(n), sc O(n)
    public int numWays1(String s) {
        int mod = (int) Math.pow(10, 9) + 7;
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') cnt++;
        }
        if (cnt % 3 != 0) return 0;
        cnt /= 3;
        Map<Integer, Integer> dp = new HashMap<>();
        int bal = 0, ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            bal += s.charAt(i) - '0';
            if (bal == cnt * 2) {
                ans += dp.getOrDefault(cnt, 0);
                ans %= mod;
            }
            dp.put(bal, dp.getOrDefault(bal, 0) + 1);
        }
        return ans;
    }
}
