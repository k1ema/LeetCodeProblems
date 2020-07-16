package binarySearch.Sqrt_69;

/**
 * 69. Sqrt(x)
 * https://leetcode.com/problems/sqrtx/
 *
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the
 * integer part of the result is returned.
 *
 * Example 1:
 * Input: 4
 * Output: 2
 *
 * Example 2:
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 */

// https://discuss.leetcode.com/topic/24532/3-4-short-lines-integer-newton-every-language
public class Solution {
    // binary search
    int mySqrt(int x) {
        if (x < 2) return x;
        int l = 1, r = x;
        while (r - l > 1) {
            int m = (l + r) >>> 1;
            if (m * m <= x) {
                l = m;
            } else {
                r = m;
            }
        }
        return l;
    }

    // Newton`s algorithm
    // https://leetcode.com/problems/valid-perfect-square/solution/

    // https://en.wikipedia.org/wiki/Integer_square_root#Using_only_integer_division
    // https://ru.wikipedia.org/wiki/%D0%90%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC_%D0%BD%D0%B0%D1%85%D0%BE%D0%B6%D0%B4%D0%B5%D0%BD%D0%B8%D1%8F_%D0%BA%D0%BE%D1%80%D0%BD%D1%8F_n-%D0%BD%D0%BE%D0%B9_%D1%81%D1%82%D0%B5%D0%BF%D0%B5%D0%BD%D0%B8
    // http://webhamster.ru/mytetrashare/index/mtb0/1684
    // https://discuss.leetcode.com/topic/24532/3-4-short-lines-integer-newton-every-language
    int mySqrt1(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }

    // tc O(1), sc O(1)
    int mySqrt2(int x) {
        if (x < 2) return x;
        int left = (int) Math.pow(Math.E, 0.5 * Math.log(x));
        int right = left + 1;
        return (long) right * right > x ? left : right;
    }
}
