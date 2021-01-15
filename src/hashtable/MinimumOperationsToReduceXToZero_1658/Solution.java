package hashtable.MinimumOperationsToReduceXToZero_1658;

import java.util.HashMap;
import java.util.Map;

/**
 * 1658. Minimum Operations to Reduce X to Zero
 * https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
 *
 * You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the
 * rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.
 *
 * Return the minimum number of operations to reduce x to exactly 0 if it's possible, otherwise, return -1.
 *
 * Example 1:
 * Input: nums = [1,1,4,2,3], x = 5
 * Output: 2
 * Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
 *
 * Example 2:
 * Input: nums = [5,6,7,8,9], x = 4
 * Output: -1
 *
 * Example 3:
 * Input: nums = [3,2,20,1,1,3], x = 10
 * Output: 5
 * Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
 *
 * Constraints:
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 * 1 <= x <= 109
 */
public class Solution {
    // tc O(n), sc O(n)
    // prefix sum
    // https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/discuss/935935/Java-Detailed-Explanation-O(N)-Prefix-SumMap-Longest-Target-Sub-Array
    public int minOperations(int[] nums, int x) {
        int target = -x;
        for (int num : nums) target += num;
        if (target == 0) return nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int res = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - target)) {
                res = Math.max(res, i - map.get(sum - target));
            }
            map.put(sum, i);
        }

        return res == Integer.MIN_VALUE ? -1 : nums.length - res;
    }

    // MLE, tc O(n), sc O(n^2)
    private final static int INF = (int) 1e6;
    public int minOperations1(int[] nums, int x) {
        int n = nums.length;
        int res = helper(nums, x, 0, n - 1, 0, 0, new Integer[n][n]);
        return res == INF ? -1 : res;
    }

    private int helper(int[] nums, int x, int l, int r, int leftSum, int rightSum, Integer[][] memo) {
        if (leftSum + rightSum == x) return 0;
        if (l == nums.length || r == -1  || l > r) return INF;
        if (memo[l][r] != null) return memo[l][r];
        int res = INF;
        if (leftSum + rightSum + nums[l] <= x) {
            res = Math.min(res, 1 + helper(nums, x, l + 1, r, leftSum + nums[l], rightSum, memo));
        }
        if (leftSum + rightSum + nums[r] <= x) {
            res = Math.min(res, 1 + helper(nums, x, l, r - 1, leftSum, rightSum + nums[r], memo));
        }
        memo[l][r] = res;
        return res;
    }

}
