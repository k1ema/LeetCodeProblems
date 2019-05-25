package math.PowerOfThree_326;

/**
 * 326. Power of Three
 * https://leetcode.com/problems/power-of-three/
 *
 * Given an integer, write a function to determine if it is a power of three.
 *
 * Example 1:
 * Input: 27
 * Output: true
 *
 *  Example 2:
 * Input: 0
 * Output: false
 *
 *  Example 3:
 * Input: 9
 * Output: true
 *
 *  Example 4:
 * Input: 45
 * Output: false
 *
 * Follow up:
 * Could you do it without using any loop / recursion?
 */
public class Solution {
    // tc Unknown, sc O(1)
    boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        double x = Math.log(Math.abs(n)) / Math.log(3);
        return Math.abs(x - Math.round(x)) < Math.pow(10, -14);
    }

    // tc O(log3(n)), sc O(1)
    boolean isPowerOfThree1(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }
}
