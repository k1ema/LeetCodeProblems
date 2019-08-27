package array.SortColors_75;

import java.util.Arrays;

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
    // tc O(n), one pass; sc O(1)
    void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) return;

        int n = nums.length - 1;
        int i = 0, j = 0;
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

        System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    void sortColors1(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int zeroes = 0;
        int ones = 0;
        int twos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroes++;
            } else if (nums[i] == 1) {
                ones++;
            } else if (nums[i] == 2) {
                twos++;
            }
        }
        for (int i = 0; i < zeroes; i++) {
            nums[i] = 0;
        }
        for (int i = zeroes; i < zeroes + ones; i++) {
            nums[i] = 1;
        }
        for (int i = zeroes + ones; i < zeroes + ones + twos; i++) {
            nums[i] = 2;
        }
    }
}
