package dynamic.NumberOfLongestIncreasingSubsequence_673;

/**
 * 673. Number of Longest Increasing Subsequence
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 *
 * Given an integer array nums, return the number of longest increasing subsequences.
 *
 * Example 1:
 * Input: nums = [1,3,5,4,7]
 * Output: 2
 * Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
 *
 * Example 2:
 * Input: nums = [2,2,2,2,2]
 * Output: 5
 * Explanation: The length of longest continuous increasing subsequence is 1,
 * and there are 5 subsequences' length is 1, so output 5.
 *
 * Constraints:
 * 0 <= nums.length <= 2000
 * -106 <= nums[i] <= 106
 */
public class Solution {
    // tc O(n^2), sc O(n)
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] len = new int[n], cnt = new int[n];
        int max_len = 0, res = 0;
        for (int i = 0; i < n; i++) {
            len[i] = 1; cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (len[i] == 1 + len[j]) {
                        cnt[i] += cnt[j];
                    } else if (len[i] < 1 + len[j]) {
                        len[i] = 1 + len[j];
                        cnt[i] = cnt[j];
                    }
                }
            }

            if (len[i] == max_len) {
                res += cnt[i];
            } else if (len[i] > max_len) {
                max_len = len[i];
                res = cnt[i];
            }
        }
        return res;
    }
}
