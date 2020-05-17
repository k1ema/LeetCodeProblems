package sorting.SortAnArray_912;

public class MergeSort implements Sort {
    @Override
    public int[] sortArray(int[] nums) {
        int[] aux = new int[nums.length];
        sort(nums, aux, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int[] aux, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(nums, aux, lo, mid);
        sort(nums, aux, mid + 1, hi);
        merge(nums, aux, lo, mid, hi);
    }

    private void merge(int[] nums, int[] aux, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = nums[i];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) nums[k] = aux[j++];
            else if (j > hi) nums[k] = aux[i++];
            else if (aux[i] < aux[j]) nums[k] = aux[i++];
            else nums[k] = aux[j++];
        }
    }
}
