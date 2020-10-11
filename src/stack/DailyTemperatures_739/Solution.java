package stack.DailyTemperatures_739;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 739. Daily Temperatures
 * https://leetcode.com/problems/daily-temperatures/
 *
 * Given a list of daily temperatures T, return a list such that, for each day in the input,
 * tells you how many days you would have to wait until a warmer temperature. If there is no
 * future day for which this is possible, put 0 instead.
 *
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your
 * output should be [1, 1, 4, 2, 1, 1, 0, 0].
 *
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will
 * be an integer in the range [30, 100].
 */
public class Solution {
    // tc O(n), sc O(n)
    // 12 ms, faster than 85.34%; 47.2 MB, less than 9.54%
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length==0) return new int[] {};
        Deque<Integer> stack = new ArrayDeque<>(); // pair: num, pos
        int[] res = new int[T.length];
        for (int i = T.length - 1; i>= 0; i--) {
            while (!stack.isEmpty() && T[i] >= T[stack.peekFirst()]) {
                stack.removeFirst();
            }
            // nums[i] < stack.peekFirst
            if (!stack.isEmpty()) res[i] = stack.peekFirst() - i;
            stack.addFirst(i);
        }
        return res;
    }

    // tc O(n), sc O(1)
    // 3 ms, faster than 99.72%; 43.1 MB, less than 84.75%
    public int[] dailyTemperatures1(int[] T) {
        int n = T.length;
        int[] dp = new int[n];
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (T[i] < T[i + 1]) {
                dp[i] = 1;
            } else {
                int v = 0;
                int ind = i + 1;
                while (dp[ind] != 0 && T[i] >= T[ind]) {
                    v += dp[ind];
                    ind += dp[ind];
                }
                if (T[i] < T[ind]) dp[i] = v + 1;
            }
        }
        return dp;
    }
}
