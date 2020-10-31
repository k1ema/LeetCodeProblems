package dynamic.LongestIncreasingSubsequence_300;

import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 *
 * Note:
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n^2) complexity.
 *
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class Solution {
    // tc O(nlogn), sc O(n)
    // 1 ms, faster than 87.28%; 37.7 MB, less than 34.00%
    // https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O(nlogn)-time-with-explanation
    public int lengthOfLIS(int[] nums) {
        if (nums == null) return 0;
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size - 1;
            while (i <= j) {
                int m = (i + j) >>> 1;
                if (x <= tails[m]) {
                    j = m - 1;
                } else {
                    i = m + 1;
                }
            }
            tails[i] = x;
            if (i == size) size++;
        }
        return size;
    }

    // tc O(n^2), sc O(n)
    // 10 ms, faster than 62.07%; 37.8 MB, less than 30.00%
    public int lengthOfLIS1(int[] nums) {
        if (nums == null) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            int j = 0;
            while (j < i) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
                j++;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // tc O(n^2), sc O(n^2)
    // 164 ms, faster than 5.05%; 91.9 MB, less than 5.01%
    public int lengthOfLIS2(int[] nums) {
        if (nums == null) return 0;
        int n = nums.length;
        int[][] memo = new int[n + 1][n];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return bt(nums, -1, 0, memo);
    }

    private int bt(int[] nums, int prev, int cur, int[][] memo) {
        if (cur == nums.length) return 0;
        if (memo[prev + 1][cur] >= 0) return memo[prev + 1][cur];
        int res = 0;
        if (prev == -1 || nums[cur] > nums[prev]) {
            res = 1 + bt(nums, cur, cur + 1, memo);
        }
        res = Math.max(res, bt(nums, prev, cur + 1, memo));
        memo[prev + 1][cur] = res;
        return res;
    }
}
