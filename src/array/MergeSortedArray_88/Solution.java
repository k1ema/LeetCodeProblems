package array.MergeSortedArray_88;

/**
 * 88. Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array/
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 */
public class Solution {
    // tc O(m + n), sc O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int i = nums1.length - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[i--] = nums1[p1--];
            } else {
                nums1[i--] = nums2[p2--];
            }
        }
        while (p2 >= 0) {
            nums1[i--] = nums2[p2--];
        }
    }

    // tc O(m*n), sc O(1)
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for (int i = 0; i < nums1.length; i++) {
            while (j < n && nums2[j] < nums1[i]) {
                insert(nums1, i++, nums2[j++]);
            }
        }
        while (j < n) {
            nums1[m + j] = nums2[j++];
        }
    }

    private void insert(int[] nums, int ind, int val) {
        for (int i = nums.length - 1; i > ind; i--) {
            nums[i] = nums[i - 1];
        }
        nums[ind] = val;
    }
}
