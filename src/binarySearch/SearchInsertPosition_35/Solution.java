package binarySearch.SearchInsertPosition_35;

/**
 * 35. Search Insert Position
 * https://leetcode.com/problems/search-insert-position/
 *
 * Given a sorted array and a target value, return the index if the target is found. If not, return
 * the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 * Input: [1,3,5,6], 5
 * Output: 2
 *
 * Example 2:
 * Input: [1,3,5,6], 2
 * Output: 1
 *
 * Example 3:
 * Input: [1,3,5,6], 7
 * Output: 4
 *
 * Example 4:
 * Input: [1,3,5,6], 0
 * Output: 0
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                if (mid + 1 < nums.length && nums[mid + 1] > target || mid == nums.length - 1) {
                    return mid + 1;
                }
                lo = mid + 1;
            } else if (nums[mid] > target) {
                if (mid - 1 >= 0 && nums[mid - 1] < target || mid == 0) {
                    return mid;
                }
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return lo;
    }
}
