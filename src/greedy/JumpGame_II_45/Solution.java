package greedy.JumpGame_II_45;

/**
 * 45. Jump Game II
 * https://leetcode.com/problems/jump-game-ii/
 *
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * You can assume that you can always reach the last index.
 *
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 *
 * Constraints:
 * 1 <= nums.length <= 3 * 10^4
 * 0 <= nums[i] <= 10^5
 */
public class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int ladder = nums[0], stairs = nums[0], jump = 1;
        for (int i = 1; i < nums.length - 1; i++) {
            if (i + nums[i] > ladder) {
                ladder = i + nums[i];
            }
            stairs--;
            if (stairs == 0) {
                jump++;
                stairs = ladder - i;
            }
        }
        return jump;
    }

    // Greedy tc O(n), sc O(1)
    public int jump3(int[] nums) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }

    // dp top-down, TLE
    // tc O(n^2), sc O(n)
    public int jump1(int[] nums) {
        return f(nums, 0, new Integer[nums.length]);
    }

    private int f(int[] nums, int i, Integer[] memo) {
        int n = nums.length;
        if (i >= n - 1) return 0;
        if (memo[i] != null) return memo[i];
        int res = n;
        for (int j = nums[i]; j > 0; j--) {
            res = Math.min(res, 1 + f(nums, i + j, memo));
        }
        memo[i] = res;
        return res;
    }

    // dp bottom-up, TLE
    // tc O(n^2), sc O(n)
    public int jump2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = n;
            if (nums[i] == 0) continue;
            for (int j = 1; j <= nums[i] && i + j < n; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i + j]);
            }
        }
        return dp[0];
    }
}
