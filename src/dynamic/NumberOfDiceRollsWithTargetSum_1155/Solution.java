package dynamic.NumberOfDiceRollsWithTargetSum_1155;

import java.util.*;

/**
 * 1155. Number of Dice Rolls With Target Sum
 * https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 *
 * You have d dice, and each die has f faces numbered 1, 2, ..., f.
 *
 * Return the number of possible ways (out of fd total ways) modulo 10^9 + 7 t
 * o roll the dice so the sum of the face up numbers equals target.
 *
 * Example 1:
 * Input: d = 1, f = 6, target = 3
 * Output: 1
 * Explanation:
 * You throw one die with 6 faces.  There is only one way to get a sum of 3.
 *
 * Example 2:
 * Input: d = 2, f = 6, target = 7
 * Output: 6
 * Explanation:
 * You throw two dice, each with 6 faces.  There are 6 ways to get a sum of 7:
 * 1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
 *
 * Example 3:
 * Input: d = 2, f = 5, target = 10
 * Output: 1
 * Explanation:
 * You throw two dice, each with 5 faces.  There is only one way to get a sum of 10: 5+5.
 *
 * Example 4:
 * Input: d = 1, f = 2, target = 3
 * Output: 0
 * Explanation:
 * You throw one die with 2 faces.  There is no way to get a sum of 3.
 *
 * Example 5:
 * Input: d = 30, f = 30, target = 500
 * Output: 222616187
 * Explanation:
 * The answer must be returned modulo 10^9 + 7.
 *
 * Constraints:
 * 1 <= d, f <= 30
 * 1 <= target <= 1000
 */
public class Solution {
    // dp
    // tc O(d * f * target)
    private int[][] dp;
    public int numRollsToTarget(int d, int f, int target) {
        dp = new int[31][1001];
        return solve(d, f, target);
    }

    private int solve(int d, int f, int target) {
        if (dp[d][target] != 0) return dp[d][target] - 1;
        if (d == 1) {
            if (target == 0) return 0;
            if (target <= f) return 1;
            return 0;
        }
        int res = 0;
        for (int i = 1; i <= f; i++) {
            int l = solve(1, f, i);
            int r = target >= i ? solve(d - 1, f, target - i) : 0;
            res = (res + (l * r)) % MOD;
        }
        dp[d][target] = res + 1;
        return res;
    }

    // backtracking with memoization
    // https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/discuss/355841/Java-Memo-DFS
    private int MOD = 1000000007;
    private Map<String, Integer> memo;
    public int numRollsToTarget1(int d, int f, int target) {
        memo = new HashMap<>();
        return bt(d, f, target);
    }

    private int bt(int d, int f, int target) {
        if (d == 0 && target == 0) return 1;
        if (d == 0 || target == 0) return 0;
        String s = d + " " + target;
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        int res = 0;
        for (int i = 1; i <= f; i++) {
            if (target >= i) {
                res = (res + bt(d - 1, f, target - i)) % MOD;
            } else {
                break;
            }
        }
        memo.put(s, res);
        return res;
    }

    // my solution
    // brute force solution without memoization, tc O(f^d), TLE
    private int res;
    public int numRollsToTarget2(int d, int f, int target) {
        res = 0;
        bt(d, f, target, new ArrayList<>(), 0);
        return res;
    }

    private void bt(int d, int f, int target, List<Integer> list, int ind) {
        if (ind == d) {
            int sum = 0;
            for (int val : list) {
                sum += val;
            }
            if (sum == target) res = (res + 1) % MOD;
            return;
        }

        for (int i = 1; i <= f; i++) {
            if (ind < d) {
                if (list.size() <= ind) {
                    list.add(i);
                } else {
                    list.set(ind, i);
                }
            }
            bt(d, f, target, list, ind + 1);
        }

        list.set(ind, 1);
    }
}

