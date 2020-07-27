package math.AddDigits_258;

/**
 * 258. Add Digits
 * https://leetcode.com/problems/add-digits/
 *
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * Example:
 * Input: 38
 * Output: 2
 *
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 *              Since 2 has only one digit, return it.
 *
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 *
 * 1234
 */
public class Solution {
    // https://leetcode.com/problems/add-digits/discuss/68667/Simple-Java-Solution-No-recursion-loop
    // tc O(1), sc O(1)
    public int addDigits(int num) {
        if (num == 0) return 0;
        if (num % 9 == 0) {
            return 9;
        }
        return num % 9;
    }

    // https://leetcode.com/problems/add-digits/discuss/68580/Accepted-C%2B%2B-O(1)-time-O(1)-space-1-Line-Solution-with-Detail-Explanations
    // tc O(1), sc O(1)
    public int addDigits1(int num) {
        return 1 + (num - 1) % 9;
    }

    // straightforward solution
    // tc O(logn), sc O(1*)
    public int addDigits2(int num) {
        if (num < 10) return num;
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return addDigits(res);
    }
}
