package dynamic.CombinationSum_IV_377;

/**
 * 377. Combination Sum IV
 * https://leetcode.com/problems/combination-sum-iv/
 *
 * Given an integer array with all positive numbers and no duplicates, find the number
 * of possible combinations that add up to a positive integer target.
 *
 * Example:
 * nums = [1, 2, 3]
 * target = 4
 *
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * Note that different sequences are counted as different combinations.
 *
 * Therefore the output is 7.
 *
 * Follow up:
 * What if negative numbers are allowed in the given array?
 * How does it change the problem?
 * What limitation we need to add to the question to allow negative numbers?
 */
public class Solution {
    // tc O(n*t), sc O(t)
    // same as #518 Coin Change II but different iteration order. Here we find all permutations inside combination
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < dp.length; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    // tc O(n*t), sc O(t)
    public int combinationSum4_(int[] nums, int target) {
        return bt(nums, target, new Integer[target + 1]);
    }

    private int bt(int[] nums, int target, Integer[] memo) {
        if (target <= 0) return target == 0 ? 1 : 0;
        if (memo[target] != null) return memo[target];
        int res = 0;
        for (int num : nums) {
            res += bt(nums, target - num, memo);
        }
        memo[target] = res;
        return res;
    }
}
