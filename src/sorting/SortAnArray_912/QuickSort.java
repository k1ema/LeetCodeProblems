package sorting.SortAnArray_912;

import java.util.Random;

public class QuickSort implements Sort {
    private Random rnd = new Random();

    @Override
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int pivotInd = partition(nums, lo, hi);
        sort(nums, lo, pivotInd - 1);
        sort(nums, pivotInd + 1, hi);
    }

    private int partition(int[] nums, int lo, int hi) {
        int pivotInd = lo + rnd.nextInt(hi - lo + 1);
        int pivot = nums[pivotInd];
        swap(nums, lo, pivotInd);
        int i = lo, j = hi;
        while (i < j) {
            while (i <= j && nums[i] <= pivot) i++;
            while (j >= i && nums[j] >= pivot) j--;
            if (i < j) swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
