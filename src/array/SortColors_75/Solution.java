package array.SortColors_75;

/**
 * 75. Sort Colors
 * https://leetcode.com/problems/sort-colors/
 *
 * Given an array with n objects colored red, white or blue, sort them in-place so that
 * objects of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with
 * total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */
public class Solution {
    // Dutch national flag problem
    // https://en.wikipedia.org/wiki/Dutch_national_flag_problem
    // https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
    // tc O(n), one pass; sc O(1)
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) return;

        int n = nums.length - 1;
        int i = 0, j = 0;
        while (j <= n) {
            if (nums[j] < 1) {
                swap(nums, i++, j++);
            } else if (nums[j] > 1) {
                swap(nums, j, n--);
            } else {
                j++;
            }
        }
    }

    // classic implementation
    public void sortColors2(int[] nums) {
        if (nums == null || nums.length == 0) return;
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int lt = lo, gt = hi;
        int v = nums[lo];
        int i = lo;
        while (i <= gt) {
            if (nums[i] < v) {
                swap(nums, i++, lt++);
            } else if (nums[i] > v) {
                swap(nums, i, gt--);
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
