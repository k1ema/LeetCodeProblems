package array.ThreeSumSmaller_259;

import java.util.Arrays;

/**
 * 259. 3SumSmaller_259
 * https://leetcode.com/problems/3sum-smaller/
 *
 * Given an array of n integers nums and an integer target, find the number of index triplets i, j, k
 * with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 *
 * Example 1:
 * Input: nums = [-2,0,1,3], target = 2
 * Output: 2
 * Explanation: Because there are two triplets which sums are less than 2:
 * [-2,0,1]
 * [-2,0,3]
 *
 * Example 2:
 * Input: nums = [], target = 0
 * Output: 0
 *
 * Example 3:
 * Input: nums = [0], target = 0
 * Output: 0
 *
 * Constraints:
 * n == nums.length
 * 0 <= n <= 3500
 * -100 <= nums[i] <= 100
 * -100 <= target <= 100
 */
public class Solution {
    // tc O(n^2), sc O(1)
    // 9 ms, faster than 31.78%; 38.8 MB, less than 13.19%
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            res += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return res;
    }

    private int twoSumSmaller(int[] nums, int startInd, int target) {
        int l = startInd, r = nums.length - 1, res = 0;
        while (l < r) {
            if (nums[l] + nums[r] < target) {
                res += r - l;
                l++;
            } else {
                r--;
            }
        }
        return res;
    }

    // binary search
    // tc O(n^2*logn), sc O(1)
    public int threeSumSmaller1(int[] nums, int target) {
        int n = nums.length;
        if (n < 3) return 0;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < i - 1; j++) {
                res += bs(nums, j, i, target);
            }
        }
        return res;
    }

    private int bs(int[] nums, int lo, int hi, int target) {
        int res = 0, l = lo, r = hi;
        int t = target - nums[lo] - nums[hi];
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (nums[m] < t) {
                l = m;
            } else {
                r = m;
            }
        }
        return l == lo ? 0 : l - lo;
    }
}
