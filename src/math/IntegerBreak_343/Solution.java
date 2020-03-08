package math.IntegerBreak_343;

/**
 * 343. Integer Break
 * https://leetcode.com/problems/integer-break/
 *
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the
 * product of those integers. Return the maximum product you can get.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 *
 * Example 2:
 * Input: 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 *
 * Note: You may assume that n is not less than 2 and not larger than 58.
 */
public class Solution {
    // tc O(n), sc O(1)
    // 0 ms, faster than 100.00%; 35.9 MB, less than 14.29%
    // https://leetcode.com/problems/integer-break/discuss/80721/Why-factor-2-or-3-The-math-behind-this-problem.
    // https://leetcode.com/problems/integer-break/discuss/80689/A-simple-explanation-of-the-math-part-and-a-O(n)-solution
    //
    // If an optimal product contains a factor f >= 4, then you can replace it with factors 2 and f-2
    // without losing optimality, as 2*(f-2) = 2f-4 >= f. So you never need a factor greater than or
    // equal to 4, meaning you only need factors 1, 2 and 3 (and 1 is of course wasteful and you'd only
    // use it for n=2 and n=3, where it's needed).
    public int integerBreak1(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int prod = 1;
        while (n > 4) {
            n -= 3;
            prod *= 3;
        }
        prod *= n;
        return prod;
    }

    // tc O(logn), sc O(1). Math.pow takes logn time
    // 0 ms, faster than 100.00%; 36.2 MB, less than 14.29%
    public int integerBreak2(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int rem = n % 3;
        if (rem == 1) return (int) Math.pow(3, (n - 4) / 3) * 4;
        if (rem == 2) return (int) Math.pow(3, n / 3) * 2;
        return (int) Math.pow(3, n / 3);
    }

    // https://leetcode.com/problems/integer-break/discuss/80903/1-liner-in-Ruby-Python
    public int integerBreak(int n) {
        if (n < 4) return n - 1;
        else return (int) Math.pow(3, ((n - 2) / 3)) * ((n - 2) % 3 + 2);
    }
}
