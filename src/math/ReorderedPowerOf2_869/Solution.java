package math.ReorderedPowerOf2_869;

import java.util.Arrays;

/**
 * 869. Reordered Power of 2
 * https://leetcode.com/problems/reordered-power-of-2/
 *
 * Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.
 *
 * Return true if and only if we can do this in a way such that the resulting number is a power of 2.
 *
 * Example 1:
 * Input: 1
 * Output: true
 *
 * Example 2:
 * Input: 10
 * Output: false
 *
 * Example 3:
 * Input: 16
 * Output: true
 *
 * Example 4:
 * Input: 24
 * Output: false
 *
 * Example 5:
 * Input: 46
 * Output: true
 *
 * Note:
 * 1 <= N <= 10^9
 */
public class Solution {
    // tc O(lgn * lgn), sc O(lgn)
    // 1 ms, faster than 96.64%; 35.7 MB, less than 88.24%
    public boolean reorderedPowerOf2(int N) {
        int[] count = count(N);
        for (int i = 0; i < 31; i++) {
            if (Arrays.equals(count, count(1 << i))) {
                return true;
            }
        }
        return false;
    }

    private int[] count(int num) {
        int[] res = new int[10];
        while (num > 0) {
            res[num % 10]++;
            num /= 10;
        }
        return res;
    }

    // tc O(lgn * (lgn)!), sc O(lgn)
    // 108 ms; 35.8 MB
    public boolean reorderedPowerOf2_(int N) {
        String s = "" + N;
        int[] nums = new int[s.length()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = s.charAt(i) - '0';
        }
        return permute(nums, 0);
    }

    private boolean permute(int[] nums, int idx) {
        if (idx == nums.length) {
            int num = 0;
            for (int d : nums) {
                num = num * 10 + d;
            }
            return (num & (num - 1)) == 0;
        }

        for (int i = idx; i < nums.length; i++) {
            if (idx == 0 && nums[i] == 0) continue;
            swap(nums, idx, i);
            if (permute(nums, idx + 1)) return true;
            swap(nums, idx, i);
        }
        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
