package stack.Pattern_132_456;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 456. 132 Pattern
 * https://leetcode.com/problems/132-pattern/
 *
 * Given an array of n integers nums, a 132 pattern is a subsequence of three integers
 * nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].
 *
 * Return true if there is a 132 pattern in nums, otherwise, return false.
 *
 * Follow up: The O(n^2) is trivial, could you come up with the O(n logn) or the O(n) solution?
 *
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: false
 * Explanation: There is no 132 pattern in the sequence.
 *
 * Example 2:
 * Input: nums = [3,1,4,2]
 * Output: true
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 *
 * Example 3:
 * Input: nums = [-1,3,2,0]
 * Output: true
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 *
 * Constraints:
 * n == nums.length
 * 1 <= n <= 10^4
 * -10^9 <= nums[i] <= 10^9
 */
public class Solution {
    // tc O(n), sc O(n)
    // 5 ms, faster than 90.19%; 39.3 MB, less than 5.91%
    /*
        - keep min value visited so far going from left to right in min array
        - keep values > min[i] visited so far going from right to left in stack
        - go from left to right, compare current nums[i] with min[i] and stack value if stack is not empty
     */
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
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
            if (!stack.isEmpty() && stack.peek() < nums[i] && nums[i] > min[i]) {
                return true;
            }
            stack.push(nums[i]);
        }
        return false;
    }

    // tc O(n^2), sc O(1)
    // 117 ms, faster than 30.81%; 39.4 MB, less than 5.91%
    public boolean find132pattern1(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            min = Math.min(min, nums[i]);
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > min && nums[j] > min && nums[j] < nums[i]) {
                    return true;
                }
            }
        }
        return false;
    }

    // tc O(n^3), sc O(1)
    // TLE
    public boolean find132pattern2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[j] > nums[i] && nums[j] > nums[k] && nums[k] > nums[i]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
