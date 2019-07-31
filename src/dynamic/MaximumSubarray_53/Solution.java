package dynamic.MaximumSubarray_53;

/**
 * 53. Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution using the divide
 * and conquer approach, which is more subtle.
 */
public class Solution {
    // tc O(n), sc O(1)
    // 1. You should build the next iteration using the data from the previous iteration.
    // 2. Think about input array as infinity-length array. In any item in array you should be able to define the result.
    // The idea is next. In every step you should make a decision: use previous subsequence + current element,
    //  or just current element.
    int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int curr = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], curr + nums[i]);
            max = Math.max(max, curr);
        }

        return max;
    }
}
