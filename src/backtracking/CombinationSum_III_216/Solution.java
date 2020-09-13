package backtracking.CombinationSum_III_216;

import java.util.*;

/**
 * 216. Combination Sum III
 * https://leetcode.com/problems/combination-sum-iii/
 *
 * Find all possible combinations of k numbers that add up to a number n, given that only
 * numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 *
 * Note:
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * Example 1:
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 *
 * Example 2:
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Solution {
    /*  tc O(A(9,k)* k) = O(9! * k / (9 - k)!),
        sc = O(k)
            During the backtracking, we used a list to keep the current combination, which
            holds up to KK elements, i.e. O(K).

            Since we employed recursion in the backtracking, we would need some additional
            space for the function call stack, which could pile up to KK consecutive
            invocations, i.e. O(K).

            Hence, to sum up, the overall space complexity would be O(K).

            Note that, we did not take into account the space for the final results in the
            space complexity.
     */
    // 0 ms, faster than 100.00%; 37 MB, less than 57.41%
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        bt(k, n, 1, res, new ArrayList<>());
        return res;
    }

    private void bt(int k, int n, int start, List<List<Integer>> res, List<Integer> cur) {
        if (cur.size() == k) {
            if (n == 0) res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i <= 9; i++) {
            cur.add(i);
            bt(k, n - i, i + 1, res, cur);
            cur.remove(cur.size() - 1);
        }
    }

    // tc O(A(9, k) * klogk), sc O(k)
    // 640 ms; 39.7 MB
    public List<List<Integer>> combinationSum3_1(int k, int n) {
        Set<List<Integer>> res = new HashSet<>();
        bt(k, n, res, new ArrayList<>());
        return new ArrayList<>(res);
    }

    private void bt(int k, int n, Set<List<Integer>> res, List<Integer> cur) {
        if (cur.size() == k) {
            int curSum = cur.stream().mapToInt(i -> i).sum();
            if (curSum == n) {
                List<Integer> l = new ArrayList<>(cur);
                Collections.sort(l);
                res.add(l);
            }
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (cur.contains(i)) continue;
            cur.add(i);
            bt(k, n, res, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
