package binarySearch.BinarySearch_704;

/**
 * 704. Binary Search
 * https://leetcode.com/problems/binary-search/
 *
 * Given a sorted (in ascending order) integer array nums of n elements and a
 * target value, write a function to search target in nums. If target exists,
 * then return its index, otherwise return -1.
 *
 * Example 1:
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 *
 * Explanation: 9 exists in nums and its index is 4
 *
 * Example 2:
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 *
 * Explanation: 2 does not exist in nums so return -1
 *
 * Note:
 * You may assume that all elements in nums are unique.
 * n will be in the range [1, 10000].
 * The value of each element in nums will be in the range [-9999, 9999].
 */
public class Solution {
    // leftmost index of non-unique element. bad numbers: nums[i] < target, good numbers: nums[i] >= target
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int l = -1, r = nums.length;
        while (r - l > 1) {
            int m = (l + r) >>> 1;
            if (nums[m] < target) {
                l = m;
            } else {
                r = m;
            }
        }
        return r != nums.length && nums[r] == target ? r : -1;
    }

    // rightmost index of non-unique element. good numbers: nums[i] <= target, bad numbers: nums[i] > target
    public int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int l = -1, r = nums.length;
        while (r - l > 1) {
            int m = (l + r) >>> 1;
            if (nums[m] <= target) {
                l = m;
            } else {
                r = m;
            }
        }
        return l >= 0 && nums[l] == target ? l : -1;
    }

    // does not work if there are non unique elements in nums and the goal is to find leftmost / rightmost index
    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) >>> 1;
            if (nums[m] == target) return m;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
}
