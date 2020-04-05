package sorting.QuickSort;

/**
 * 3-way Dijkstra partitioning or Dutch national flag problem
 * https://en.wikipedia.org/wiki/Dutch_national_flag_problem
 * https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 */
public class ThreeWayPartitioning {
    void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int lt = lo, gt = hi;
        int pivot = nums[lo];
        int i = lo;
        while (i <= gt) {
            if (nums[i] < pivot) {
                swap(nums, i, lt);
                i++;
                lt++;
            } else if (nums[i] > pivot) {
                swap(nums, i, gt);
                gt--;
            } else {
                i++;
            }
        }
        sort(nums, lo, lt - 1);
        sort(nums, gt + 1, hi);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
