package sorting.MergeSort;

public class MergeSort {
    private int[] aux;

    // Top-down MergeSort
    public void sort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        aux = new int[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(nums, lo, mid);
        sort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    private void merge(int[] nums, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = nums[k];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                nums[k] = aux[j++];
            } else if (j > hi) {
                nums[k] = aux[i++];
            } else if (aux[i] < aux[j]) {
                nums[k] = aux[i++];
            } else {
                nums[k] = aux[j++];
            }
        }
    }

    // Bottom-up MergeSort
    public void sort1(int[] nums) {
        int n;
        if (nums == null || (n = nums.length) < 2) return;
        aux = new int[n];
        for (int sz = 1; sz < n; sz = sz + sz) {
            for (int lo = 0; lo < n - sz; lo += sz + sz) {
                merge(nums, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, n - 1));
            }
        }
    }
}
