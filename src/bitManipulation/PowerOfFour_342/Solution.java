package bitManipulation.PowerOfFour_342;

/**
 * 342. Power of Four
 * https://leetcode.com/problems/power-of-four/
 *
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 *
 * Example 2:
 * Input: 5
 * Output: false
 *
 * Follow up: Could you solve it without loops/recursion?
 */
public class Solution {
    boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }

    boolean isPowerOfFour2(int n) {
        boolean isPow2 = n > 0 && (n & (n - 1)) == 0;
        return isPow2 && Integer.toBinaryString(n).length() % 2 == 1;
    }

    // alternative math version
    // 1 ms, faster than 100.00%; 33.7 MB, less than 6.67%
    boolean isPowerOfFour1(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        double x = Math.log10(n) / Math.log10(4);
        return (x % (int) x) == 0;
    }
}
