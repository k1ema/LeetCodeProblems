package binarySearch.ValidPerfectSquare_367;

/**
 * 367. Valid Perfect Square
 * https://leetcode.com/problems/valid-perfect-square/
 *
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 * Input: 16
 * Output: true
 *
 * Example 2:
 * Input: 14
 * Output: false
 */
public class Solution {
    // tc O(logn) ,sc O(1)
    public boolean isPerfectSquare(int num) {
        long l = 0, r = num;
        while (r - l > 1) {
            long m = (l + r) >>> 1;
            if (m * m < num) {
                l = m;
            } else {
                r = m;
            }
        }
        return r * r == num;
    }

    // Newton's method
    // https://leetcode.com/problems/valid-perfect-square/solution/
    // tc O(logn) ,sc O(1)
    public boolean isPerfectSquare1(int num) {
        if (num < 2) return true;
        long x = num / 2;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return x * x == num;
    }
}
