package array.NonDecreasingArray_665;

import java.util.Arrays;

/**
 * 665. Non-decreasing Array
 * https://leetcode.com/problems/non-decreasing-array/
 *
 * Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
 * We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
 *
 * Example 1:
 * Input: [4,2,3]
 * Output: True
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 *
 *  Example 2:
 * Input: [4,2,1]
 * Output: False
 * Explanation: You can't get a non-decreasing array by modify at most one element.
 *
 * Note: The n belongs to [1, 10,000].
 */
class Solution {
    boolean checkPossibility(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        boolean b = checkNonReducing(nums);
        if (b) {
            return true;
        }
        int[] tmp = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                tmp[0] = tmp[1];
            } else {
                tmp[i] = tmp[i - 1];
            }
            if (checkNonReducing(tmp)) {
                return true;
            }
            tmp[i] = nums[i];
        }
        return false;
    }

    boolean checkNonReducing(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // leetcode
    // https://leetcode.com/problems/non-decreasing-array/discuss/106826/JavaC%2B%2B-Simple-greedy-like-solution-with-explanation
    boolean checkPossibility1(int[] nums) {
        int cnt = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                cnt++;
                if (i - 2 < 0 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
            }
        }
        return cnt <= 1;
    }
}
