package bitManipulation.SumOfTwoIntegers_371;

/**
 * 371. Sum of Two Integers
 * https://leetcode.com/problems/sum-of-two-integers/
 *
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 *
 * Example 1:
 * Input: a = 1, b = 2
 * Output: 3
 *
 *  Example 2:
 * Input: a = -2, b = 3
 * Output: 1
 */
public class Solution {
    public int getSum(int a, int b) {
        if ((a & b) == 0) {
            return a ^ b;
        }
        return getSum(a ^ b, (a & b) << 1);
    }

    // https://leetcode.com/problems/sum-of-two-integers/discuss/84290/Java-simple-easy-understand-solution-with-explanation
    int getSum1(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }

        return a;
    }
}
