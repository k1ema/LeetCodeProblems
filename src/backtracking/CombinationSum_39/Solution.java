package backtracking.CombinationSum_39;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. Combination Sum
 * https://leetcode.com/problems/combination-sum/
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find
 * all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * Example 2:
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class Solution {
    // tc O(n^target), sc O()
    // 3 ms, faster than 73.91%; 41.7 MB, less than 5.19%
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        bt(candidates, target, 0, res, new ArrayList<>());
        return res;
    }

    private void bt(int[] nums, int target, int start, List<List<Integer>> res, List<Integer> tmp) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
        } else {
            for (int i = start; i < nums.length; i++) {
                tmp.add(nums[i]);
                bt(nums, target - nums[i], i, res, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
