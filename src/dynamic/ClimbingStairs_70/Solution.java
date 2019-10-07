package dynamic.ClimbingStairs_70;

/**
 * 70. Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class Solution {
    // bottom-up solution
    // tc O(n), sc O(1)
    // 0 ms, faster than 100.00%; 32.9 MB, less than 5.26%
    // to get to step i we can either from step i - 1 using 1 step or from i - 2 using 2 step.
    // So getting to step i is equals to sum of steps(i - 1) + steps(i - 2). Classical fibonacci problem.
    int climbStairs(int n) {
        if (n < 3) return n;
        int first = 1;
        int second = 2;
        for (int i = 2; i < n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    // bottom-up solution
    // tc O(n), sc O(n)
    // 0 ms, faster than 100.00%; 33 MB, less than 5.26%
    int climbStairs1(int n) {
        if (n < 3) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n - 1];
    }

    // top-down solution
    // tc O(n), sc O(n)
    // 0 ms, faster than 100.00%; 33 MB, less than 5.26%
    private int[] dp;
    int climbStairs2(int n) {
        if (n < 3) return n;
        dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        return fib(n);
    }

    private int fib(int n) {
        if (n < 3) return n;
        if (dp[n] == 0) {
            dp[n] = fib(n - 2) + fib(n - 1);
        }
        return dp[n];
    }
}
