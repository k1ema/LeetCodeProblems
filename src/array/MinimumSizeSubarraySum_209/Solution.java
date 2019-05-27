package array.MinimumSizeSubarraySum_209;

/**
 * 209. Minimum Size Subarray Sum
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 *
 * Given an array of n positive integers and a positive integer s, find the minimal length
 * of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example:
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2

 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the
 * time complexity is O(n log n).
 */
public class Solution {
    // tc O(n), sc O(1)
    int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j++];

            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= nums[i++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    // tc O(n2), sc O(1)
    int minSubArrayLen1(int s, int[] nums) {
        if (nums == null || nums.length == 1 && nums[0] < s) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        }
        int min_count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= s) {
                return 1;
            }
            int j = i + 1;
            int sum = nums[i];
            int count = 1;
            while (j < nums.length) {
                sum += nums[j++];
                count++;
                if (sum >= s) {
                    break;
                }
            }
            if (sum >= s && (min_count == 0 || count < min_count && i != nums.length - 1)) {
                min_count = count;
            }
        }

        return min_count <= nums.length ? min_count : 0;
    }
}
