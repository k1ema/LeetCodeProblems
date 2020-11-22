package binarySearch.SearchInRotatedSortedArray_II_81;

/**
 * 81. Search in Rotated Sorted Array II
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 *
 * You are given a target value to search. If found in the array return true, otherwise return false.
 *
 * Example 1:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * Follow up:
 *
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int n = nums.length;
        int shift_index = 0;
        if (nums[n - 1] <= nums[0]) {
            int l = -1, r = n;
            while (r - l > 1) {
                int m = (l + r) >>> 1;
                if (good(nums, m, l)) {
                    l = m;
                } else {
                    r = m;
                }
            }
            shift_index = r;
        }
//        System.out.println(shift_index);
        int l = shift_index - 1, r = shift_index + n;
        while (r - l > 1) {
            int m = (l + r) >>> 1;
            if (nums[m % n] < target) {
                l = m;
            } else {
                r = m;
            }
        }
        return nums[r % n] == target;
    }

    private boolean good(int[] nums, int m, int l) {
        boolean b = nums[m] >= nums[Math.max(0, l)];
        if (nums[m] == nums[Math.max(0, l)]) {
            int k = Math.max(0, l);
            for (int i = k + 1; i <= m; i++) {
                if (nums[i] != nums[i - 1]) return false;
            }
        }
        return b;
    }
}
