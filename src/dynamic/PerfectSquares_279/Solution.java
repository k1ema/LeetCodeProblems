package dynamic.PerfectSquares_279;

import java.util.*;

/**
 * 279. Perfect Squares
 * https://leetcode.com/problems/perfect-squares/
 *
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Example 1:
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 *
 * Example 2:
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
public class Solution {
    // top-down with memo
    // tc O(n*sqrt(n)), sc O(n)
    // 550 ms, faster than 8.35%; 57.3 MB, less than 5.01%
    public int numSquares(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return bt(n, memo);
    }

    private int bt(int n, Map<Integer, Integer> memo) {
        if (n == 0) return 0;
        if (memo.containsKey(n)) return memo.get(n);
        int res = n;
        int i = 1;
        while (i * i <= n) {
            res = Math.min(res, 1 + bt(n - i * i, memo));
            i++;
        }
        memo.put(n, res);
        return res;
    }

    // bottom-up
    // tc O(n * sqrt(n)), sc O(n)
    // 66 ms, faster than 34.73%; 38.5 MB, less than 5.01%
    /*
        0 1 2 3 4 5 6 7 8 9 10 11 12 13
    1   0 1 2 3 4 5 6 7 8 9 10 11 12 13
    4   0 1 2 3 1 2 3 4 2 3  4  5  3  4
    9   0 1 2 3 1 2 3 4 2 1  2  3  3  2
    */
    public int numSquares1(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }
        for (int i = 4; i <= n; i++) {
            for (int j = 2; j * j <= i; j++) {
                int s = j * j;
                if (s % i == 0) {
                    dp[i] = s / i;
                } else {
                    dp[i] = Math.min(dp[i], dp[s] + dp[i - s]);
                }
            }
        }
        return dp[n];
    }

    // tc O(n^(h/2)) where h is the maximal number of recursion that could happen.
    // sc O(sqrt(n))
    public int numSquares12(int n) {
        Set<Integer> square_nums = new HashSet<>();
        for (int i = 1; i * i <= n; ++i) {
            square_nums.add(i * i);
        }

        int count = 1;
        for (; count <= n; ++count) {
            if (is_divided_by(n, count, square_nums))
                return count;
        }
        return count;
    }

    protected boolean is_divided_by(int n, int count, Set<Integer> square_nums) {
        if (count == 1) {
            return square_nums.contains(n);
        }
        for (int square : square_nums) {
            if (is_divided_by(n - square, count - 1, square_nums)) {
                return true;
            }
        }
        return false;
    }

    // Greedy + BFS
    // tc O(n^(h/2)) where h is the height of the N-ary tree.
    // sc O(sqrt(n))
    public int numSquares3(int n) {
        ArrayList<Integer> square_nums = new ArrayList<>();
        for (int i = 1; i * i <= n; ++i) {
            square_nums.add(i * i);
        }

        Set<Integer> queue = new HashSet<>();
        queue.add(n);

        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            Set<Integer> next_queue = new HashSet<>();

            for (int remainder : queue) {
                for (int square : square_nums) {
                    if (remainder == square) {
                        return level;
                    } else if (remainder < square) {
                        break;
                    } else {
                        next_queue.add(remainder - square);
                    }
                }
            }
            queue = next_queue;
        }
        return level;
    }
}
