package sorting.QuickSort;

/**
 * 3-way Dijkstra partitioning or Dutch national flag problem
 * https://en.wikipedia.org/wiki/Dutch_national_flag_problem
 * https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 */
public class ThreeWayPartitioning {
    void sort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int i = 0, j = 0, n = nums.length - 1;
        while (j <= n) {
            if (nums[j] < 1) {
                swap(nums, i, j);
                i++;
                j++;
            } else if (nums[j] > 1) {
                swap(nums, j, n);
                n--;
            } else {
                j++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
