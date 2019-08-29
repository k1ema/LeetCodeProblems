package sorting.QuickSort;

import java.util.Random;

/**
 * Quick selection problem: find Kth element in array.
 */
public class QuickSelection {
    int findKthLargest(int[] nums, int k) {
        int n;
        if (nums == null || (n = nums.length) == 0) return 0;
        k = n - k;
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int j = partition(nums, lo, hi);
            if (k > j) {
                lo = j + 1;
            } else if (k < j) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    // recursive
    int findKthLargest1(int[] nums, int k) {
        int n;
        if (nums == null || (n = nums.length) == 0) return 0;
        k = n - k;
        return helper(nums, 0, n - 1, k);
    }

    private int helper(int[] nums, int lo, int hi, int k) {
        if (lo >= hi) return nums[hi];
        int j = partition(nums, lo, hi);
        if (k > j) {
            return helper(nums, j + 1, hi, k);
        } else if (k < j) {
            return helper(nums, lo, j - 1, k);
        } else {
            return nums[k];
        }
    }

    private Random rnd = new Random();
    private int partition(int[] nums, int lo, int hi) {
        int pivotInd = lo + rnd.nextInt(hi - lo + 1);
        int pivot = nums[pivotInd];
        swap(nums, lo, pivotInd);

        int i = lo, j = hi;
        while (i < j) {
            while (i <= j && nums[i] <= pivot) i++;
            while (i <= j && nums[j] > pivot) j--;
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
