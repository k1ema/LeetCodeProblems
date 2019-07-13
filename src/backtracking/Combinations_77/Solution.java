package backtracking.Combinations_77;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. Combinations
 * https://leetcode.com/problems/combinations/
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * Example:
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Solution {
    // tc O(C(n,k)), sc O(C(n,k)) ?
    List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private void backtrack(List<List<Integer>> combs, List<Integer> temp, int start, int n, int k) {
        if (k == 0) {
            combs.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i <= n-k+1; i++) {
            temp.add(i);
            backtrack(combs, temp, i + 1, n, k - 1);
            temp.remove(temp.size() - 1);
        }
    }
}
