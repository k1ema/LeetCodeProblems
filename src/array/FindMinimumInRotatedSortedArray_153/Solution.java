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
    // tc O(logn), sc O(1)
    int findMin(int[] nums) {
        // if the last element is greater than the first element then there is no rotation.
        // e.g. 1 < 2 < 3 < 4 < 5 < 7. Already sorted array.
        // Hence the smallest element is first element. A[0]
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // if the mid element is greater than its next element then mid+1 element is the smallest
            // This point would be the point of change. From higher to lower value.
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            // if the mid element is lesser than its previous element then mid element is the smallest
            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            // if the mid elements value is greater than the 0th element this means the least value
            // is still somewhere to the right as we are still dealing with elements greater than nums[0]
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                // if nums[0] is greater than the mid value then this means the smallest value is somewhere to the left
                right = mid - 1;
            }
        }
        return -1;
    }

    // https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/discuss/48493/Compact-and-clean-C%2B%2B-solution
    // tc O(logn), sc O(1)
    int findMin1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // if the last element is greater than the first element then there is no rotation.
            // e.g. 1 < 2 < 3 < 4 < 5 < 7. Already sorted array.
            // Hence the smallest element is first element. A[0]
            if (nums[left] < nums[right]) {
                return nums[left];
            }

            int m = left + (right - left) / 2;

            if (nums[m] >= nums[left]) {
                left = m + 1;
            } else {
                right = m;
            }
        }
        return nums[left];
    }

    // tc O(logn), sc O(1)
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
    int findMin3(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) return nums[i];
        }
        return nums[0];
    }
}
