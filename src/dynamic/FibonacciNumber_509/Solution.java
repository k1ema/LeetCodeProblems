package dynamic.FibonacciNumber_509;

/**
 * 509. Fibonacci Number
 * https://leetcode.com/problems/fibonacci-number/
 *
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci
 * sequence, such that each number is the sum of the two preceding ones, starting
 * from 0 and 1. That is,
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), for N > 1.
 * Given N, calculate F(N).
 *
 * Example 1:
 * Input: 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 *
 * Example 2:
 * Input: 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 *
 * Example 3:
 * Input: 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 * Note:
 * 0 ≤ N ≤ 30.
 */
public class Solution {
    // tc O(n), sc O(1)
    // 0 ms, faster than 100.00%; 33 MB, less than 5.51%
    int fib(int n) {
        if (n == 0 || n == 1) return n;
        int prev = 1, nextprev = 0, cur = prev;
        for (int i = 2; i <= n; i++) {
            cur = prev + nextprev;
            nextprev = prev;
            prev = cur;
        }
        return cur;
    }

    // tc O(n), sc O(n)
    // 0 ms, faster than 100.00%; 32.9 MB, less than 5.51%
    int fib1(int n) {
        if (n == 0 || n == 1) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // recursion: 8 ms, faster than 33.64%; 32.8 MB, less than 5.51%
    // tc(2^n), sc O(n)
    int fib2(int n) {
        if (n == 0 || n == 1) return n;
        return fib2(n - 1) + fib2(n - 2);
    }
}
