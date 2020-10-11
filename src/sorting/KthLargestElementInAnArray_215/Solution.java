package sorting.KthLargestElementInAnArray_215;

import java.util.Arrays;
import java.util.PriorityQueue;
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
    private final static Random rnd = new Random();

    // quick-select
    // tc O(n), 1 ms, faster than 99.49%; 36.6 MB, less than 90.67%
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        k = n - k;
        int l = 0, r = n - 1;
        while (l < r) {
            int pInd = partition(nums, l, r);
            if (k < pInd) {
                r = pInd - 1;
            } else if (k > pInd) {
                l = pInd + 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private int partition(int[] nums, int lo, int hi) {
        int pivotInd = lo + rnd.nextInt(hi - lo + 1);
        int pivot = nums[pivotInd];
        swap(nums, lo, pivotInd);
        int i = lo, j = hi;
        while (i < j) {
            while (i <= j && nums[i] <= pivot) i++;
            while (i <= j && nums[j] >= pivot) j--;
            if (i < j) swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // heap, tc O(nlogk), sc O(k)
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Integer::compare);
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }

    // tc O(nlogn), sc O(1); 2ms
    int findKthLargest2(int[] nums, int k) {
        final int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
    }

    // tc O(n * k), sc O(n * k); 54ms
    int findKthLargest3(int[] nums, int k) {
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
