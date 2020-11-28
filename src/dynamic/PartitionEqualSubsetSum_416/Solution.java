package dynamic.PartitionEqualSubsetSum_416;

import java.util.stream.IntStream;

/**
 * 416. Partition Equal Subset Sum
 * https://leetcode.com/problems/partition-equal-subset-sum/
 *
 * Given a non-empty array containing only positive integers, find if the array can be
 * partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 * Note:
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 *
 * Example 1:
 * Input: [1, 5, 11, 5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 * Example 2:
 * Input: [1, 2, 3, 5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class Solution {
    // top-down recursion with memoization
    // tc O(2^n) w/o memo, O(n*s) with memo; sc O(n*s), where n - nums.length and s = total sum
    // 3 ms, faster than 88.98%; 43.1 MB, less than 22.22%
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2) return false;
        int sum = IntStream.of(nums).sum();
        if (sum % 2 == 1) return false;
        Boolean[][] memo = new Boolean[nums.length][sum / 2 + 1];
        return bt(nums, 0, sum / 2, memo);
    }

    private boolean bt(int[] nums, int idx, int sum, Boolean[][] memo) {
        if (sum == 0) return true;
        if (idx == nums.length) return false;
        if (memo[idx][sum] != null) return memo[idx][sum];
        if (sum - nums[idx] >= 0) {
            if (bt(nums, idx + 1, sum - nums[idx], memo)) {
                memo[idx][sum] = true;
                return true;
            }
        }
        memo[idx][sum] = bt(nums, idx + 1, sum, memo);
        return memo[idx][sum];
    }

    // dp bottom-up
    // tc O(n*s), sc O(n*s)
    // 33 ms, faster than 41.40%; 39.2 MB, less than 69.84%
    public boolean canPartition1(int[] nums) {
        int m = nums.length;
        int sum = IntStream.of(nums).map(i -> i).sum();
        if (sum % 2 == 1) return false;
        sum /= 2;
        boolean[][] dp = new boolean[m][sum + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (j < nums[i]) continue;
                if (j == nums[i]) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = (i != 0 && dp[i - 1][j]) || (i != 0 && dp[i - 1][j - nums[i]]);
                }
            }
        }
        return dp[m - 1][sum];
    }

    // tc O(n*s), sc O(sum)
    // https://leetcode.com/problems/partition-equal-subset-sum/discuss/90592/01-knapsack-detailed-explanation
    // https://www.youtube.com/watch?v=s6FhG--P7z0
    // https://www.youtube.com/watch?v=8LusJS5-AGo
    public boolean canPartition2(int[] nums) {
        int sum = IntStream.of(nums).sum();
        if ((sum & 1) == 1) return false;
        sum /= 2;

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        // why did we go from the right instead of left?
        // answer1: if we go from left to right, the dp[i - num] has been updated with current iteration and the status from last iteration is lost.
        //
        // answer2: In 2D array our current row is updated with the values from the previous row. When we use a boolean array only,
        // if we traverse from left to right, the leftmost value gets updated and its previous value gets replaced. For the elements
        // on the right, we need the old values of the leftmost elements not the updated ones. When we traverse from right to left,
        // we are using the old values to update our boolean array.
        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[sum];
    }
}