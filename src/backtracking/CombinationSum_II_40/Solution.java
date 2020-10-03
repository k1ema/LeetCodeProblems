package backtracking.CombinationSum_II_40;

import java.util.*;

/**
 * 40. Combination Sum II
 * https://leetcode.com/problems/combination-sum-ii/
 *
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique
 * combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class Solution {
    // tc O(nlogn + n^(t/m + 1)) = O(n^(t/m + 1)), sc O(t/m),
    // where n - num of cand, t - target, m - min num value in candidates
    // 4 ms, faster than 69.79%; 39 MB, less than 68.42%
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, res, new ArrayList<>());
        return res;
    }

    private void helper(int[] nums, int target, int start, List<List<Integer>> res, List<Integer> tmp) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
        } else {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) continue; // skip duplicates
                tmp.add(nums[i]);
                helper(nums, target - nums[i], i + 1, res, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    // my solution
    // 14 ms, faster than 12.58%; 39.6 MB, less than 48.42%
    public List<List<Integer>> combinationSum2_(int[] candidates, int target) {
        if (candidates == null) return new ArrayList<>();
        Set<List<Integer>> res = new HashSet<>();
        helper(candidates, target, 0, res, new ArrayList<>());
        return new ArrayList<>(res);
    }

    private void helper(int[] nums, int target, int start, Set<List<Integer>> res, List<Integer> tmp) {
        if (target < 0) return;
        if (target == 0) {
            List<Integer> ls = new ArrayList<>(tmp);
            Collections.sort(ls);
            res.add(ls);
        } else {
            for (int i = start; i < nums.length; i++) {
                tmp.add(nums[i]);
                helper(nums, target - nums[i], i + 1, res, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
