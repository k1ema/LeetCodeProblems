package binarySearch.FindMinimumInRotatedSortedArray_II_154;

/**
 * 154. Find Minimum in Rotated Sorted Array II
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * The array may contain duplicates.
 *
 * Example 1:
 *
 * Input: [1,3,5]
 * Output: 1
 * Example 2:
 *
 * Input: [2,2,2,0,1]
 * Output: 0
 * Note:
 *
 * This is a follow up problem to Find Minimum in Rotated Sorted Array.
 * Would allow duplicates affect the run-time complexity? How and why?
 */
public class Solution {
    // tc O(logn) in average, in worst case O(n) [1,2,2,2,2,...], sc O(1)
    // 0 ms, faster than 100.00%; 39.3 MB, less than 72.06%
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = -1, r = n - 1;
        while (r - l > 1) {
            int m = (l + r) >>> 1;
            if (nums[m] < nums[r]) {
                r = m;
            } else if (nums[m] > nums[r]) {
                l = m;
            } else {
                r--;
            }
        }
        return nums[r];
    }
}
