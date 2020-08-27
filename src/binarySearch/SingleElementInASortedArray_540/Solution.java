package binarySearch.SingleElementInASortedArray_540;

/**
 * 540. Single Element in a Sorted Array
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 *
 * You are given a sorted array consisting of only integers where every element appears
 * exactly twice, except for one element which appears exactly once. Find this single
 * element that appears only once.
 *
 * Example 1:
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 *
 * Example 2:
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 *
 * Note: Your solution should run in O(log n) time and O(1) space.
 */
public class Solution {
    // tc O(logn), sc O(1)
    // 0 ms, faster than 100.00%; 39.6 MB, less than 79.56%
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        int l = -1, r = nums.length;
        while (r - l > 1) {
            int m = (l + r) >>> 1;
            if (isGood(nums, m)) {
                l = m;
            } else {
                r = m;
            }
        }
        return r == nums.length ? nums[l] : nums[r];
    }

    private boolean isGood(int[] nums, int m) {
        return m % 2 == 0 && (m == nums.length - 1 || nums[m] == nums[m + 1]) || m % 2 == 1 && nums[m] == nums[m - 1];
    }

    public int singleNonDuplicate1(int[] nums) {
        if (nums.length == 1) return nums[0];
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (mid == 0 && nums[mid] != nums[mid + 1]
                    || mid == nums.length - 1 && nums[mid] != nums[mid - 1]) return nums[mid];

            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            if (mid % 2 == 1) {
                if (nums[mid] == nums[mid - 1]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {
                if (nums[mid] == nums[mid - 1]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }

        }
        return nums[lo];
    }
}
