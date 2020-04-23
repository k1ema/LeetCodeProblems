package bitManipulation.BitwiseANDOfNumbersRange_201;

/**
 * 201. Bitwise AND of Numbers Range
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/
 *
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise
 * AND of all numbers in this range, inclusive.
 *
 * Example 1:
 * Input: [5,7]
 * Output: 4
 *
 *  Example 2:
 * Input: [0,1]
 * Output: 0
 */
public class Solution {
    // tc O(1), sc O(1)
    // https://leetcode.com/articles/bitwise-and-of-numbers-range/
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            shift++;
        }
        return m << shift;
    }

    // tc O(1), sc O(1)
    // Brian Kernighan's Algorithm
    public int rangeBitwiseAnd1(int m, int n) {
        while (n > m) {
            n = n & (n - 1);
        }
        return m & n;
    }
}
