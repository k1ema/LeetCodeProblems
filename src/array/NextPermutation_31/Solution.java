package array.NextPermutation_31;

/**
 * 31. Next Permutation
 * https://leetcode.com/problems/next-permutation/
 *
 * Implement next permutation, which rearranges numbers into the lexicographically
 * next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible
 * order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding
 * outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class Solution {
    // tc O(n), sc O(1)
    // 0 ms, faster than 100.00%; 39 MB, less than 88.35%
    // https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
    public void nextPermutation(int[] nums) {
        boolean fountPivot = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                fountPivot = true;
                int j = nums.length - 1;
                while (j > i && nums[j] <= nums[i]) {
                    j--;
                }
                swap(nums, i, j);
                reverse(nums, i + 1);
                break;
            }
        }
        if (!fountPivot) {
            reverse(nums, 0);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void reverse(int[] nums, int from) {
        int i = from, j = nums.length - 1;
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
