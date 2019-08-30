package array.WiggleSort_II_324;

import java.util.Arrays;
import java.util.Random;

/**
 * 324. Wiggle Sort II
 * https://leetcode.com/problems/wiggle-sort-ii/
 *
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 *
 * Example 1:
 * Input: nums = [1, 5, 1, 1, 6, 4]
 * Output: One possible answer is [1, 4, 1, 5, 1, 6].
 *
 * Example 2:
 * Input: nums = [1, 3, 2, 2, 3, 1]
 * Output: One possible answer is [2, 3, 1, 3, 1, 2].
 *
 * Note:
 * You may assume all input has valid answer.
 *
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
public class Solution {
    void wiggleSort(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) < 2) return;

        int median = findKthSmallest(nums, len >> 1);

        // use dutch national flag algorithm
        // https://en.wikipedia.org/wiki/Dutch_national_flag_problem
        int i = 0, j = 0, n = len - 1;
        while (j <= n) {
            if (nums[ind(j, len)] > median) {
                swap(nums, ind(j, len), ind(i, len));
                i++;
                j++;
            } else if (nums[ind(j, len)] < median) {
                swap(nums, ind(j, len), ind(n, len));
                n--;
            } else {
                j++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private int ind(int i, int n) {
        return (1 + 2 * i) % (n | 1);
    }

    // from #215
    private int findKthSmallest(int[] nums, int k) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int j = partition(nums, lo, hi);
            if (j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private Random rnd = new Random();
    private int partition(int[] nums, int lo, int hi) {
        int pivotInd = lo + rnd.nextInt(hi - lo + 1);
        int pivot = nums[pivotInd];
        swap(nums, pivotInd, lo);

        int i = lo, j = hi;
        while (i < j) {
            while (i <= j && nums[i] <= pivot) i++;
            while (i <= j && nums[j] >= pivot) j--;
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, lo, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
