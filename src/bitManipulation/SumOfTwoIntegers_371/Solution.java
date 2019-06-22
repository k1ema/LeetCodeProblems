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
    // my solution
    int getSum2(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        int sum = 0;
        int s = 0;
        for (int i = 0; i < 32; i++) {
            int aa = (a & (1 << i)) >>> i;
            int bb = (b & (1 << i)) >>> i;
            if ((aa & bb) == 1) {
                if (s == 1) {
                    sum |= 1 << i;
                } else {
                    s = 1;
                }
                continue;
            }
            if (s == 1) {
                if (aa == 0 && bb == 0) {
                    sum |= 1 << i;
                    s = 0;
                }
            } else {
                sum |= (aa | bb) << i;
            }
        }
        return sum;
    }

    // https://leetcode.com/problems/sum-of-two-integers/discuss/84290/Java-simple-easy-understand-solution-with-explanation
    int getSum(int a, int b) {
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
