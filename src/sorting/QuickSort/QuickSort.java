package sorting.QuickSort;

public class QuickSort {
    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int pivotIndex = partition(nums, lo, hi);
        sort(nums, lo, pivotIndex - 1);
        sort(nums, pivotIndex + 1, hi);
    }

    int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int i = lo;
        int j = hi;
        while (i < j) {
            while (i <= j && nums[i] <= pivot) {
                i++;
            }
            while (j >= i && nums[j] > pivot) {
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
}
