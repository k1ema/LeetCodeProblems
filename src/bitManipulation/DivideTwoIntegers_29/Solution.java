package bitManipulation.DivideTwoIntegers_29;

/**
 * 29. Divide Two Integers
 * https://leetcode.com/problems/divide-two-integers/
 *
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 * Return the quotient after dividing dividend by divisor.
 * The integer division should truncate toward zero, which means losing its fractional part. For example,
 * truncate(8.345) = 8 and truncate(-2.7335) = -2.
 *
 * Note:
 * Assume we are dealing with an environment that could only store integers within the 32-bit signed integer
 * range: [−231,  231 − 1]. For this problem, assume that your function returns 231 − 1 when the division result overflows.
 *
 * Example 1:
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = truncate(3.33333..) = 3.
 *
 * Example 2:
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = truncate(-2.33333..) = -2.
 *
 * Example 3:
 * Input: dividend = 0, divisor = 1
 * Output: 0
 *
 * Example 4:
 * Input: dividend = 1, divisor = 1
 * Output: 1
 *
 * Constraints:
 * -2^31 <= dividend, divisor <= 2^31 - 1
 * divisor != 0
 */
public class Solution {
    // tc O(logn)
    public int divide(int dividend, int divisor) {
        if (divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
        int sign = 1;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
            sign = -1;
        }
        long dvd = Math.abs((long) dividend), dvs = Math.abs((long) divisor);
        int res = 0;
        while (dvs <= dvd) {
            long temp = dvs;
            int count = 1;
            while ((temp << 1) <= dvd) {
                temp <<= 1;
                count <<= 1;
            }
            dvd -= temp;
            res += count;
        }
        return res * sign;
    }

    // TLE, tc O(n)
    public int divide1(int dividend, int divisor) {
        if (divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
        int sign = 1;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
            sign = -1;
        }
        long dvd = Math.abs((long) dividend), dvs = Math.abs((long) divisor);
        long val = dvs, count = 0;
        while (dvs <= dvd) {
            dvs += val;
            count++;
        }
        return (int) count * sign;
    }
}
