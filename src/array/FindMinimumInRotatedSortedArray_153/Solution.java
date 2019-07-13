package array.FindMinimumInRotatedSortedArray_153;

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
    // https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/discuss/48493/Compact-and-clean-C%2B%2B-solution
    // tc, sc O(logn)
    int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            if (nums[lo] < nums[hi]) return nums[lo];
            int m = lo + (hi - lo) / 2;
            if (nums[m] >= nums[lo]) lo = m + 1;
            else hi = m;
        }
        return nums[lo];
    }

    // tc, sc O(logn)
    int findMin2(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int m = lo + (hi - lo) / 2;
            if (nums[m] > nums[lo]) {
                lo = m;
            } else if (nums[m] < nums[lo]) {
                hi = m;
            } else {
                return Math.min(nums[0], Math.min(nums[lo], nums[hi]));
            }
        }
        return Math.min(nums[0], nums[lo]);
    }

    // tc O(n), sc O(1)
    int findMin1(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) return nums[i];
        }
        return nums[0];
    }
}
