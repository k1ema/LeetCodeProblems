package sorting.SortAnArray_912;

public class HeapSort implements Sort {
    private int[] nums;
    private int n;

    @Override
    public int[] sortArray(int[] nums) {
        this.nums = nums;
        n = nums.length - 1;
        for (int i = n / 2; i >= 0; i--) {
            sink(i);
        }
        while (n > 0) {
            swap(0, n--);
            sink(0);
        }
        return nums;
    }

    private void sink(int i) {
        while (2 * i <= n) {
            int j = 2 * i;
            if (j < n && nums[j] < nums[j + 1]) j++;
            if (!less(i, j)) break;
            swap(i, j);
            i = j;
        }
    }

    private boolean less(int i, int j) {
        return nums[i] < nums[j];
    }

    private void swap(int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
