package dynamic.MaximumSumOf3NonOverlappingSubarrays_689;

/**
 * 689. Maximum Sum of 3 Non-Overlapping Subarrays
 * https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/
 *
 * Given an integer array nums and an integer k, find three non-overlapping subarrays of length k with maximum sum and return them.
 *
 * Return the result as a list of indices representing the starting position of each interval (0-indexed).
 * If there are multiple answers, return the lexicographically smallest one.
 *
 * Example 1:
 * Input: nums = [1,2,1,2,6,7,5,1], k = 2
 * Output: [0,3,5]
 * Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
 * We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
 *
 * Example 2:
 * Input: nums = [1,2,1,2,1,2,1,2,1], k = 2
 * Output: [0,2,4]
 *
 * Constraints:
 * 1 <= nums.length <= 2 * 10^4
 * 1 <= nums[i] < 2^16
 * 1 <= k <= floor(nums.length / 3)
 */
public class Solution {
    // tc O(n), sc O(n)
    public int[] maxSumOfThreeSubarrays1(int[] nums, int k) {
        int n = nums.length;
        int prefixSum = 0;
        int[] sums = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            if (i >= k) {
                prefixSum -= nums[i - k];
            }
            if (i >= k - 1) {
                sums[i - k + 1] = prefixSum;
            }
        }

        int[] left = new int[sums.length];
        int best = 0;
        for (int i = 0; i < left.length; i++) {
            if (sums[i] > sums[best]) best = i;
            left[i] = best;
        }

        int[] right = new int[sums.length];
        best = sums.length - 1;
        for (int i = right.length - 1; i >= 0; i--) {
            if (sums[i] >= sums[best]) best = i;
            right[i] = best;
        }

        int[] res = new int[] {-1, -1, -1};
        for (int j = k; j < sums.length - k; j++) {
            int i = left[j - k], l = right[j + k];
            if (res[0] == -1 || sums[i] + sums[j] + sums[l] > sums[res[0]] + sums[res[1]] + sums[res[2]]) {
                res[0] = i;
                res[1] = j;
                res[2] = l;
            }
        }
        return res;
    }

    // top-down with memo
    // tc O(n), sc O(n)
    // 13 ms, faster than 9.63%; 49 MB, less than 16.82%
    // https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/discuss/846729/C%2B%2B-Top-Down-Dynamic-Programming-w-generic-idea
    private int[] res;
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int prefixSum = 0;
        int[] sums = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            if (i >= k) {
                prefixSum -= nums[i - k];
            }
            if (i >= k - 1) {
                sums[i - k + 1] = prefixSum;
            }
        }
        Integer[][] memo = new Integer[sums.length][4];
        res = new int[3];
        dfs(0, 0, k, sums, memo);
        return res;
    }

    private void dfs(int i, int resInd, int k, int[] sums, Integer[][] memo) {
        if (resInd == 3) return;
        int take = sums[i] + dp(i + k, resInd + 1, k, sums, memo);
        int not_take = dp(i + 1, resInd, k, sums, memo);
        if (take >= not_take) {
            res[resInd] = i;
            dfs(i + k, resInd + 1, k, sums, memo);
        } else {
            dfs(i + 1, resInd, k, sums, memo);
        }
    }

    private int dp(int i, int resInd, int k, int[] sums, Integer[][] memo) {
        if (resInd == 3 || i >= sums.length) {
            return 0;
        }
        if (memo[i][resInd] != null) {
            return memo[i][resInd];
        }
        int take = sums[i] + dp(i + k, resInd + 1, k, sums, memo);
        int not_take = dp(i + 1, resInd, k, sums, memo);
        return memo[i][resInd] = Math.max(take, not_take);
    }
}
