package binarySearch.FindFirstAndLastPositionOfElementInSortedArray_34;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending
 * position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class Solution {
    // tc O(logn), sc O(1)
    int[] searchRange(int[] nums, int target) {
        int[] res = new int[] {-1, -1};
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return res;
        }
        if (len == 1) {
            return nums[0] == target ? new int[] {0, 0} : res;
        }

        int lo = 0;
        int hi = len - 1;
        while (lo <= hi) {
            int m = lo + (hi - lo) / 2;
            if (nums[m] < target) {
                lo++;
            } else if (nums[m] > target) {
                hi--;
            } else {
                int i = m;
                while (i - 1 >= lo && nums[i - 1] == target) {
                    i--;
                }
                res[0] = i;

                while (m + 1 <= hi && nums[m + 1] == target) {
                    m++;
                }
                res[1] = m;
                break;
            }
        }

        return res;
    }
}
