package dynamic.MaximumProductSubarray_152;

/**
 * 152. Maximum Product Subarray
 * https://leetcode.com/problems/maximum-product-subarray/
 *
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 *
 * Example 1:
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 *
 * Example 2:
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class Solution {
    // tc O(n), sc O(1)
    int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int currMaxCopy = currMax;
            currMax = Math.max(Math.max(nums[i], currMax * nums[i]), currMin * nums[i]);
            currMin = Math.min(Math.min(nums[i], currMin * nums[i]), currMaxCopy * nums[i]);
            max = Math.max(max, currMax);
        }

        return max;
    }
}
