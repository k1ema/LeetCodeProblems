package math.FactorialTrailingZeroes_172;

/**
 * 172. Factorial Trailing Zeroes
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 *
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Example 1:
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 *
 * Example 2:
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * Note: Your solution should be in logarithmic time complexity.
 */
public class Solution {
    // https://leetcode.com/problems/factorial-trailing-zeroes/discuss/52373/Simple-CC%2B%2B-Solution-(with-detailed-explaination)
    // https://leetcode.com/problems/factorial-trailing-zeroes/discuss/52371/My-one-line-solutions-in-3-languages
    // https://www.purplemath.com/modules/factzero.htm
    int trailingZeroes(int n) {
        int result = 0;
        while (n / 5 != 0) {
            result += n / 5;
            n = n / 5;
        }
        return result;
    }

    int trailingZeroes1(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes1(n / 5);
    }
}
