package binarySearch.MissingElementInSortedArray_1060;

/**
 * 1060. Missing Element in Sorted Array
 * https://leetcode.com/problems/missing-element-in-sorted-array/
 *
 * Given an integer array nums which is sorted in ascending order and all of its elements are unique and given
 * also an integer k, return the kth missing number starting from the leftmost number of the array.
 *
 * Example 1:
 * Input: nums = [4,7,9,10], k = 1
 * Output: 5
 * Explanation: The first missing number is 5.
 *
 * Example 2:
 * Input: nums = [4,7,9,10], k = 3
 * Output: 8
 * Explanation: The missing numbers are [5,6,8,...], hence the third missing number is 8.
 *
 * Example 3:
 * Input: nums = [1,2,4], k = 3
 * Output: 6
 * Explanation: The missing numbers are [3,5,6,7,...], hence the third missing number is 6.
 *
 * Constraints:
 * 1 <= nums.length <= 5 * 10^4
 * 1 <= nums[i] <= 10^7
 * nums is sorted in ascending order, and all the elements are unique.
 * 1 <= k <= 10^8
 *
 * Follow up: Can you find a logarithmic time complexity (i.e., O(log(n))) solution?
 */
public class Solution {
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = n;
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (nums[m] - nums[0] - m < k) {
                l = m;
            } else {
                r = m;
            }
        }
        return nums[0] + k + l; // == nums[l] + k - (nums[l] - nums[0] - l)
    }
}
