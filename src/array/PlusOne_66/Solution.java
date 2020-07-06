package array.PlusOne_66;

/**
 * 66. Plus One
 * https://leetcode.com/problems/plus-one/
 *
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and
 * each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 *
 * Example 2:
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int ind = n - 1;
        while (ind >= 0 && digits[ind] == 9) ind--;
        if (ind >= 0) {
            if (ind != n - 1) {
                for (int i = ind + 1; i < n; i++) {
                    digits[i] = 0;
                }
            }
            digits[ind]++;
            return digits;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }
}
