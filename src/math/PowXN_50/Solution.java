package math.PowXN_50;

/**
 * 50. Pow(x, n)
 * https://leetcode.com/problems/powx-n/
 *
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 *
 * Example 1:
 *
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 *
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 *
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * Note:
 *
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−231, 231 − 1]
 */
public class Solution {
    // tc O(logn), sc O(1)
    public double myPow(double x, int n) {
        if (n == 0 || x == 1d) return 1d;
        long N = n;
        if (N < 0) N = -N;
        double mult = x;
        double res = 1d;
        while (N != 0) {
            if (N % 2 == 1) {
                res *= mult;
            }
            mult *= mult;
            N >>=1;
        }
        return n > 0 ? res : 1 / res;
    }

    // tc O(logn), sc O(logn)
    public double myPow1(double x, int n) {
        if (n == 0) return 1;
        if (n == 1 || x == 1) return x;
        double v = myPow(x, Math.abs(n / 2));
        double res = n % 2 == 0 ? v * v : x * v * v;
        return n > 0 ? res : 1 / res;
    }

    // TLE
    public double myPow2(double x, int n) {
        double res = 1;
        for (int i = 0; i < Math.abs(n); i++) {
            res *= x;
        }
        return n < 0 ? 1 / res : res;
    }
}
