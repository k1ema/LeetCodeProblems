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
    // Lexicographical permutation algorithm
    // https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
    // tc O(n), worst case O(nlogn) if sort needed, sc O(1)
    void nextPermutation(int[] nums) {
        // find pivot
        int pivotInd = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                pivotInd = i - 1;
                break;
            }
        }
        // if pivot didn't find -> we have the last permutation
        if (pivotInd == -1) {
            // reverse or just Arrays.sort(nums)
            reverse(nums, 0, nums.length - 1);
            return;
        }

        // let's find the last num that greater than pivot
        int swapInd = 0;
        for (int i = nums.length - 1; i > pivotInd; i--) {
            if (nums[i] > nums[pivotInd]) {
                swapInd = i;
                break;
            }
        }

        // and than swap them: nums[pivotInd] and nums[swapInd]
        swap(nums, pivotInd, swapInd);

        // and reverse nums[pivotInd+1..]
        reverse(nums, pivotInd + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

    private void reverse(int[] nums, int from, int to) {
        while (from < to) {
            swap(nums, from, to);
            from++;
            to--;
        }
    }
}