package array.RotateArray_189;

/**
 * 189. Rotate Array
 * https://leetcode.com/problems/rotate-array/
 *
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *
 * Example 2:
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
public class Solution {
    // tc O(n), sc O(1)
    // 1 ms, faster than 41.79%; 42.5 MB, less than 5.77%
    void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2) return;
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    // tc O(n*k), sc O(1)
    // 211 ms, faster than 9.99%; 40 MB, less than 5.77%
    void rotate1(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int v1 = nums[nums.length - 1];
            int v2;
            for (int j = 0; j < nums.length; j++) {
                v2 = nums[j];
                nums[j] = v1;
                v1 = v2;
            }
        }
    }
}
