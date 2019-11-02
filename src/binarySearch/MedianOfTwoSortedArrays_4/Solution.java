package binarySearch.MedianOfTwoSortedArrays_4;

/**
 * 4. Median of Two Sorted Arrays
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 *
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 */
public class Solution {
    // tc O(log(min(m,n))), sc O(1)
    // 3 ms, faster than 38.05%; 46.7 MB, less than 90.97%
    // https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2481/Share-my-O(log(min(mn)))-solution-with-explanation
    // https://www.youtube.com/watch?v=LPFhl65R7ww
    double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) throw new IllegalArgumentException();
        int m, n;
        if (nums1 == null || (m = nums1.length) == 0) {
            return median(nums2);
        } else if (nums2 == null || (n = nums2.length) == 0) {
            return median(nums1);
        }

        if (m > n) return findMedianSortedArrays(nums2, nums1);

        int lo = 0, hi = m;
        while (lo <= hi) {
            int partitionX = lo + (hi - lo) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;

            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = partitionX == m ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = partitionY == n ? Integer.MAX_VALUE : nums2[partitionY];

            int maxLeft = Math.max(maxLeftX, maxLeftY);
            int minRight = Math.min(minRightX, minRightY);

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                return (m + n) % 2 != 0 ? maxLeft : maxLeft + (minRight - maxLeft) / 2.0;
            } else if (maxLeftX > minRightY) {
                hi = partitionX - 1;
            } else {
                lo = partitionX + 1;
            }
        }

        return 0;
    }

    private double median(int[] nums) {
        int n = nums != null ? nums.length : 0;
        return n == 0 ? 0 : n % 2 != 0 ? nums[n / 2] : nums[n / 2 - 1] + (nums[n / 2] - nums[n / 2 - 1]) / 2.0;
    }
}
