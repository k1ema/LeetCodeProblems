package dynamic.PerfectSquares_279;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    /*
        use dp
            int[] dp = new dp[n + 1];
            for i = 0 .. n
                for sqr : sqr_list
                    if (num[i] is square)
                        dp[i] = 1;
                    else
                        dp[i] = min(dp[i], dp[i - sqr] + 1)
            return dp[n]

     i    0 1 2 3 4 5 6 7 8 9 10 11 12 13
  dp[i]   0 1 2 3 1 2 3 4 2 1  2  3  3  2
    */
    // tc O(n * sqrt(n)), sc O(n)
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }
        List<Integer> sqrList = new ArrayList<>();
        for (int i = 4; i <= n; i++) {
            int sqrt = (int) Math.sqrt(i);
            if (i - sqrt * sqrt == 0) {
                dp[i] = 1;
                sqrList.add(i);
            } else {
                for (int sqr : sqrList) {
                    dp[i] = Math.min(dp[i], dp[i - sqr] + 1);
                }
            }
        }
        return dp[n];
    }

    // tc O(n^(h/2)) where h is the maximal number of recursion that could happen.
    // sc O(sqrt(n))
    public int numSquares1(int n) {
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
    public int numSquares2(int n) {
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
