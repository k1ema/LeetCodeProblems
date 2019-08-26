package array.WiggleSort_280;

/**
 * 280. Wiggle Sort
 * https://leetcode.com/problems/wiggle-sort
 *
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 */
public class Solution {
    // tc O(n), sc O(1)
    // TODO check it in leetcode!
    void wiggleSort(int[] nums) {
        int n;
        if (nums == null || (n = nums.length) < 2) return;

        for (int i = 1; i < n; i++) {
            if ((i & 1) == 1 && nums[i] < nums[i - 1]) {
                swap(nums, i, i - 1);
            } else if ((i & 1) == 0 && nums[i] > nums[i - 1]){
                swap(nums, i, i - 1);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // tc O(n), sc O(1)
    void wiggleSort2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 0 && nums[i] > nums[i - 1]) {
                swap(nums, i, i - 1);
            }
            if (i % 2 == 1 && nums[i] < nums[i - 1]) {
                swap(nums, i, i - 1);
            }
        }
    }
}
