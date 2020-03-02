package array.ProductOfArrayExceptSelf_238;

import java.util.Arrays;

/**
 * 238. Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/
 *
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to
 * the product of all the elements of nums except nums[i].
 *
 * Example:
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for
 * the purpose of space complexity analysis.)
 */
public class Solution {
    // tc O(n), sc O(1)
    // 2 ms, faster than 25.35%; 47.9 MB, less than 5.51%
    // https://leetcode.com/problems/product-of-array-except-self/discuss/65667/My-one-pass-Java-solution-without-extra-spaces
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        int left = 1, right = 1;
        for (int i = 0, j = nums.length - 1; i < nums.length - 1 && j > 0; i++, j--) {
            left *= nums[i];
            right *= nums[j];
            result[i + 1] *= left;
            result[j - 1] *= right;
        }
        return result;
    }
}
