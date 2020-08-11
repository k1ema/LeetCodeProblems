package binarySearch.FindMinimumInRotatedSortedArray_153;

/**
 * 153. Find Minimum in Rotated Sorted Array
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 *
 * Example 1:
 * Input: [3,4,5,1,2]
 * Output: 1
 *
 * Example 2:
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 */
public class Solution {
    // tc O(logn), sc O(1)
    // 0 ms, faster than 100.00%; 38.9 MB, less than 90.34%
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n;
        while (r - l > 1) {
            int m = (l + r) >>> 1;
            if (nums[m] > nums[l]) {
                l = m;
            } else {
                r = m;
            }
        }
        return r < n ? nums[r] : nums[0];
    }
}
