package math.ReverseInteger_7;

import java.util.ArrayList;
import java.util.List;

/**
 * 7. Reverse Integer
 * https://leetcode.com/problems/reverse-integer/
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 * Input: 123
 * Output: 321
 *
 * Example 2:
 * Input: -123
 * Output: -321
 *
 * Example 3:
 * Input: 120
 * Output: 21
 *
 * Note:
 * Assume we are dealing with an environment which could only store integers within
 * the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem,
 * assume that your function returns 0 when the reversed integer overflows.
 */
public class Solution {
    // tc O(n), sc O(n)
    int reverse(int x) {
        if (x == 0 || x == Integer.MIN_VALUE) {
            return 0;
        }
        String s = "" + Math.abs(x);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char tmp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = tmp;
        }
        int r;
        try {
            r = Integer.parseInt(new String(chars));
        } catch (Exception e) {
            return 0;
        }
        return x > 0 ? r : -r;
    }

    // https://leetcode.com/problems/reverse-integer/discuss/4060/My-accepted-15-lines-of-code-for-Java
    int reverse1(int x) {
        int result = 0;

        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;
    }
}
