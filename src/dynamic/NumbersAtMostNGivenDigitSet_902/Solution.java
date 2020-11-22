package dynamic.NumbersAtMostNGivenDigitSet_902;

import java.util.HashSet;
import java.util.Set;

/**
 * 902. Numbers At Most N Given Digit Set
 * https://leetcode.com/problems/numbers-at-most-n-given-digit-set/
 *
 * Given an array of digits, you can write numbers using each digits[i] as many times as we want.
 * For example, if digits = ['1','3','5'], we may write numbers such as '13', '551', and '1351315'.
 *
 * Return the number of positive integers that can be generated that are less than or equal to a given integer n.
 *
 * Example 1:
 * Input: digits = ["1","3","5","7"], n = 100
 * Output: 20
 * Explanation:
 * The 20 numbers that can be written are:
 * 1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
 *
 * Example 2:
 * Input: digits = ["1","4","9"], n = 1000000000
 * Output: 29523
 * Explanation:
 * We can write 3 one digit numbers, 9 two digit numbers, 27 three digit numbers,
 * 81 four digit numbers, 243 five digit numbers, 729 six digit numbers,
 * 2187 seven digit numbers, 6561 eight digit numbers, and 19683 nine digit numbers.
 * In total, this is 29523 integers that can be written using the digits array.
 *
 * Example 3:
 * Input: digits = ["7"], n = 8
 * Output: 1
 *
 * Constraints:
 * 1 <= digits.length <= 9
 * digits[i].length == 1
 * digits[i] is a digit from '1' to '9'.
 * All the values in digits are unique.
 * 1 <= n <= 109
 */
public class Solution {
    // dp, tc O(m * logn), where m = digits.length. If m is limited (up to 9) -> tc O(logn), sc O(1)
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String nStr = "" + n;
        int nLen = nStr.length();
        int[] dp = new int[nLen + 1];
        dp[nLen] = 1;
        for (int i = nLen - 1; i >= 0; i--) {
            for (String d : digits) {
                if (d.charAt(0) < nStr.charAt(i)) {
                    dp[i] += Math.pow(digits.length, nLen - i - 1);
                } else if (d.charAt(0) == nStr.charAt(i)) {
                    dp[i] += dp[i + 1];
                }
            }
        }
        for (int i = 1; i < nLen; i++) {
            dp[0] += Math.pow(digits.length, i);
        }
        return dp[0];
    }

    // tc O(m * logn), where m = digits.length. If m is limited (up to 9) -> tc O(logn), sc O(1)
    public int atMostNGivenDigitSet1(String[] digits, int n) {
        int res = 0;
        String nStr = Integer.toString(n);
        int len = nStr.length();
        for (int i = 1; i < len; i++) {
            res += Math.pow(digits.length, i);
        }

        for (int i = 0; i < len; i++) {
            boolean hasSameNum = false;
            for (String d : digits) {
                if (d.charAt(0) < nStr.charAt(i)) {
                    res += Math.pow(digits.length, len - i - 1);
                } else if (d.charAt(0) == nStr.charAt(i)) {
                    hasSameNum = true;
                }
            }
            if (!hasSameNum) return res;
        }
        return res + 1;
    }

    // brute force, TLE, tc O(Σ(n^k), k=1..logn)
    public int atMostNGivenDigitSet2(String[] digits, int n) {
        Set<Integer> used = new HashSet<>();
        bt(digits, n, new StringBuilder(), used);
        return used.size();
    }

    private void bt(String[] digits, int n, StringBuilder cur, Set<Integer> used) {
        if (cur.length() > 0) {
            long num = Long.parseLong(cur.toString());
            if (num <= n) used.add((int) num);
            else return;
        }
        for (String digit : digits) {
            cur.append(digit);
            bt(digits, n, cur, used);
            cur.setLength(cur.length() - 1);
        }
    }
}
