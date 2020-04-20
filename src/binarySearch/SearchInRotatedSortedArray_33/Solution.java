package binarySearch.SearchInRotatedSortedArray_33;

/**
 * 33. Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class Solution {
    // find shift (min element index), then use classic binary search considering this shift
    // tc O(logn), sc O(1)
    // 0 ms, faster than 100.00%; 38.1 MB, less than 47.17%
    public int search(int[] nums, int target) {
        int n = nums.length;
        int minInd = 0;
        if (nums[0]> nums[n - 1]) {
            minInd = findMinIndex(nums);
        }
        int lo = minInd, hi = n - 1 + minInd;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid % n] < target) {
                lo = mid + 1;
            } else if (nums[mid % n] > target) {
                hi = mid - 1;
            } else {
                return mid % n;
            }
        }
        return -1;
    }

    private int findMinIndex(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid + 1 < nums.length && nums[mid + 1] < nums[mid]) {
                return mid + 1;
            } else if (nums[mid] > nums[lo]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    // one pass, https://leetcode.com/problems/search-in-rotated-sorted-array/solution/
    // tc O(logn), sc O(1)
    // 0 ms, faster than 100.00%; 38.2 MB, less than 46.54%
    public int search1(int[] nums, int target) {
        int n;
        if (nums == null || (n = nums.length) == 0) return -1;

        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[mid] >= nums[lo]) {
                    if (target < nums[mid] && target >= nums[lo]) {
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                } else {
                    if (target > nums[mid] && target <= nums[hi]) {
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }
            }
        }
        return -1;
    }
}
