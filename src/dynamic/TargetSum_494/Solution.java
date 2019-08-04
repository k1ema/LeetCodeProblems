package dynamic.TargetSum_494;

import java.util.Arrays;

/**
 * 494. Target Sum
 * https://leetcode.com/problems/target-sum/
 *
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you
 * have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 *
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 *
 * Example 1:
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 *
 * Explanation:
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 *
 * Note:
 * The length of the given array is positive and will not exceed 20.
 * The sum of elements in the given array will not exceed 1000.
 * Your output answer is guaranteed to be fitted in a 32-bit integer.
 */
public class Solution {
    // dp, tc O(n*s), where n is nums.length, sc O(s)
    // https://leetcode.com/problems/target-sum/discuss/97334/Java-(15-ms)-C%2B%2B-(3-ms)-O(ns)-iterative-DP-solution-using-subset-sum-with-explanation
    //
    // Given nums = [1, 2, 3, 4, 5] and target = 3 then one possible solution is +1-2+3-4+5 = 3
    // Here positive subset is P = [1, 3, 5] and negative subset is N = [2, 4]
    //
    // Then let's see how this can be converted to a subset sum problem:
    //                   sum(P) - sum(N) = target
    // sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
    //                        2 * sum(P) = target + sum(nums)
    // So the original problem has been converted to a subset sum problem as follows:
    // Find a subset P of nums such that sum(P) = (target + sum(nums)) / 2
    // Note that the above formula has proved that target + sum(nums) must be even
    //
    // explanation on how to solve subset sum problem:
    // suppose we have nums = [1,2,3,4,5] and t=3; sum(p) = 9
    // the matrix where rows are nums and columns are subset sum is shown below:
    //   | 9 8 7 6 5 4 3 2 1 0
    // 1 | 0 0 0 0 0 0 0 0 1 1
    // 2 | 0 0 0 0 0 0 1 1 1 1
    // 3 | 0 0 0 1 1 1 2 1 1 1
    // 4 | 1 1 2 2 2 2 2 1 1 1
    // 5 | 3 3 3 3 3 2 2 1 1 1
    // the result is number in [4][9] with equals to number of subsets with sum = 9

    int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1);
    }

    private int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = s; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[s];
    }

    // tc O(l * n), The memo array of size l*n has been filled just once.
    // Here, l refers to the range of sum and n refers to the size of nums array.
    // sc O(n), The depth of recursion tree can go upto n
    int findTargetSumWays2(int[] nums, int S) {
        int[][] memo = new int[nums.length][2001];
        for (int[] row: memo)
            Arrays.fill(row, Integer.MIN_VALUE);
        return calculate(nums, 0, 0, S, memo);
    }
    private int calculate(int[] nums, int i, int sum, int S, int[][] memo) {
        if (i == nums.length) {
            if (sum == S)
                return 1;
            else
                return 0;
        } else {
            if (memo[i][sum + 1000] != Integer.MIN_VALUE) {
                return memo[i][sum + 1000];
            }
            int add = calculate(nums, i + 1, sum + nums[i], S, memo);
            int subtract = calculate(nums, i + 1, sum - nums[i], S, memo);
            memo[i][sum + 1000] = add + subtract;
            return memo[i][sum + 1000];
        }
    }

    // tc O(2^n), sc O(n), classic dfs
    private int sums = 0;
    int findTargetSumWays1(int[] nums, int S) {
        dfs(nums, S, 0, 0);
        return sums;
    }

    private void dfs(int[] nums, int S, int i, int sum) {
        if (i == nums.length) {
            if (sum == S) {
                sums++;
            }
            return;
        }

        dfs(nums, S, i + 1, sum + nums[i]);
        dfs(nums, S, i + 1, sum - nums[i]);
    }
}
