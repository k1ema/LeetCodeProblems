package array.KthLargestElementInAnArray_215;

import java.util.Arrays;
import java.util.Random;

/**
 * 215. Kth Largest Element in an Array
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element
 * in the sorted order, not the kth distinct element.
 *
 * Example 1:
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 *
 * Example 2:
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class Solution {
    // A Random object we will use later repeatedly to choose random pivots
    private final static Random rnd = new Random();

    // tc O(n), 1 ms, faster than 99.49%; 36.6 MB, less than 90.67%
    int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        k = n - k;
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int pInd = partition(nums, lo, hi);
            if (k < pInd) {
                hi = pInd - 1;
            } else if (k > pInd) {
                lo = pInd + 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    // tc O(n); 1 ms, faster than 99.49%; 36.5 MB, less than 90.67%
    int findKthLargest2(int[] nums, int k) {
        return findKthLargest(nums, k, 0, nums.length - 1);
    }

    private int findKthLargest(int[] nums, int k, int lo, int hi) {
        int pInd = partition(nums, lo, hi);
        int resInd = hi + 1 - k;
        if (resInd < pInd) {
            return findKthLargest(nums, pInd - resInd, lo, pInd - 1);
        } else if (resInd > pInd) {
            return findKthLargest(nums, k, pInd + 1, hi);
        } else {
            return nums[resInd];
        }
    }

    private int partition(int[] nums, int lo, int hi) {
        // Pick a random pivot. Bounds are [lo, hi].
        int pivotInd = lo + rnd.nextInt(hi - lo + 1);
        int pivot = nums[pivotInd];
        swap(nums, pivotInd, lo);

        int i = lo, j = hi;
        while (i < j) {
            while (i <= j && nums[i] <= pivot) {
                i++;
            }
            while (i <= j && nums[j] > pivot) {
                j--;
            }
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

    // good explanation: https://github.com/bephrem1/backtobackswe/blob/master/Sorting%2C%20Searching%2C%20%26%20Heaps/kthLargestElement.java
    // 1 ms, faster than 99.49%; 36.8 MB, less than 90.67%
    // tc O(n), sc O(1)
    int findKthLargest3(int[] nums, int k) {
        int n = nums.length;
        int lo = 0;
        int hi = n - 1;
        k = n - k;
        while (lo <= hi) {
            int pivotInd = lo + rnd.nextInt(hi - lo + 1);
            int j = partition(nums, lo, hi, pivotInd);
            if (j == k) {
                return nums[k];
            } else if (j < k) {
                lo = j + 1;
            } else {
                hi = j - 1;
            }
        }
        return -1;
    }

    private int partition(int[] nums, int lo, int hi, int pivotInd) {
        int pivot = nums[pivotInd];
        swap(nums, pivotInd, hi);
        int lesserItemsInd = lo;
        for (int i = lo; i < hi; i++) {
            if (nums[i] < pivot) {
                swap(nums, lesserItemsInd++, i);
            }
        }
        swap(nums, hi, lesserItemsInd);
        return lesserItemsInd;
    }

    // tc O(nlogn), sc O(1); 2ms
    int findKthLargest4(int[] nums, int k) {
        final int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
    }

    // tc O(n * k), sc O(n * k); 54ms
    int findKthLargest5(int[] nums, int k) {
        Integer[] max = new Integer[k];
        for (int num : nums) {
            checkNum(max, num);
        }
        return max[k - 1];
    }

    private void checkNum(Integer[] max, int num) {
        Integer current = num;
        for (int i = 0; i < max.length; i++) {
            if (current != null && (max[i] == null || current > max[i])) {
                Integer tmp = max[i];
                max[i] = current;
                current = tmp;
            }
        }
    }
}
