package array.IncreasingTripletSubsequence_334;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 334. Increasing Triplet Subsequence
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 *
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k) such
 * that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
 *
 * Example 1:
 * Input: nums = [1,2,3,4,5]
 * Output: true
 * Explanation: Any triplet where i < j < k is valid.
 *
 * Example 2:
 * Input: nums = [5,4,3,2,1]
 * Output: false
 * Explanation: No triplet exists.
 *
 * Example 3:
 * Input: nums = [2,1,5,0,4,6]
 * Output: true
 * Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 *
 * Constraints:
 * 1 <= nums.length <= 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 *
 * Follow up: Could you implement a solution that runs in O(n) time complexity and O(1) space complexity?
 */
public class Solution {
    // tc O(n), sc O(1)
    public boolean increasingTriplet(int[] nums) {
        int num1 = Integer.MAX_VALUE, num2 = Integer.MAX_VALUE;
        for (int v : nums) {
            if (v <= num1) {
                num1 = v;
            } else if (v <= num2) {
                num2 = v;
            } else {
                return true;
            }
        }
        return false;
    }

    // tc O(n), sc O(n)
    public boolean increasingTriplet1(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;
        int[] min = new int[n];
        min[0] = nums[0];
        for (int i = 1; i < n; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i > 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= min[i]) {
                stack.poll();
            }
            if (!stack.isEmpty() && stack.peek() > nums[i] && nums[i] > min[i]) {
                return true;
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
