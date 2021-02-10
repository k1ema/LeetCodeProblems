package dynamic.NumbersWithSameConsecutiveDifferences_967;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 967. Numbers With Same Consecutive Differences
 * https://leetcode.com/problems/numbers-with-same-consecutive-differences/
 *
 * Return all non-negative integers of length N such that the absolute difference between
 * every two consecutive digits is K.
 *
 * Note that every number in the answer must not have leading zeros except for the number
 * 0 itself. For example, 01 has one leading zero and is invalid, but 0 is valid.
 *
 * You may return the answer in any order.
 *
 * Example 1:
 * Input: N = 3, K = 7
 * Output: [181,292,707,818,929]
 * Explanation: Note that 070 is not a valid number, because it has leading zeroes.
 *
 * Example 2:
 * Input: N = 2, K = 1
 * Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 *
 * Note:
 * 1 <= N <= 9
 * 0 <= K <= 9
 */
public class Solution {
    // tc O(10*2^(N-1)), because we start with all digits and then each step we have at most two options.
    // sc is the same
    // 5 ms, faster than 54.10%; 38.9 MB, less than 92.54%
    public int[] numsSameConsecDiff(int N, int K) {
        if (N == 1) return new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        upperbound = (int) Math.pow(10, N);
        lowerbound = (int) Math.pow(10, N - 1);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            dfs(N, K, 0, i, set);
        }
        int[] res = set.stream().mapToInt(i -> i).filter(this::validNum).toArray();
        Arrays.sort(res);
        System.out.println(Arrays.toString(res));
        return res;
    }

    private void dfs(int N, int K, int num, int val, Set<Integer> set) {
        if (N == 0) {
            set.add(num);
            return;
        }
        if (val < 0 || val > 9) return;
        num = num * 10 + val;
        dfs(N - 1, K, num, (num % 10) - K, set);
        dfs(N - 1, K, num, (num % 10) + K, set);
    }

    // tc O(10*10^(N-1)) = O(10^N), sc O(10*2^(N-1))
    // 5 ms, 39.8 MB
    private int upperbound, lowerbound;
    public int[] numsSameConsecDiff1(int N, int K) {
        upperbound = (int) Math.pow(10, N);
        lowerbound = N == 1 ? 0 : (int) Math.pow(10, N - 1);
        List<Integer> list = new ArrayList<>();
        bt(N, K, 0, N - 1, list);
        return list.stream().mapToInt(i -> i).filter(this::validNum).toArray();
    }

    private void bt(int N, int K, int num, int i, List<Integer> list) {
        if (i < 0) {
            list.add(num);
            return;
        }
        for (int j = 0; j < 10; j++) {
            if (i == N - 1 || Math.abs((num % 10) - j) == K) {
                num = num * 10 + j;
                bt(N, K, num, i - 1, list);
                num /= 10;
            }
        }
    }

    private boolean validNum(int num) {
        return num >= lowerbound && num < upperbound;
    }
}
