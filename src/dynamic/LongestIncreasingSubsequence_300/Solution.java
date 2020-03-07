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
 * Your algorithm should run in O(n2) complexity.
 *
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class Solution {
    // tc O(n^2), sc O(n)
    // 10 ms, faster than 62.07%; 37.8 MB, less than 30.00%
    public int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int maxVal = 0;
            int j = i - 1;
            while (j >= 0) {
                if (nums[j] < nums[i]) {
                    maxVal = Math.max(maxVal, dp[j]);
                }
                j--;
            }
            dp[i] = maxVal + 1;
        }
        Arrays.sort(dp);
        return dp[nums.length - 1];
    }

    // tc O(nlogn), sc O(n)
    // 1 ms, faster than 87.28%; 37.7 MB, less than 34.00%
    // https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O(nlogn)-time-with-explanation
    public int lengthOfLIS(int[] nums) {
        if (nums == null) return 0;
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i < j) {
                int m = i + (j - i) / 2;
                if (x <= tails[m]) {
                    j = m;
                } else {
                    i = m + 1;
                }
            }
            tails[i] = x;
            if (i == size) size++;
        }
        return size;
    }
}
