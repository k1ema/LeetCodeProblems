package backtracking.Subsets_II_90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. Subsets II
 * https://leetcode.com/problems/subsets-ii/
 *
 * Given a collection of integers that might contain duplicates, nums, return all
 * possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class Solution {
    // tc O(n * 2^n), sc O(2^n)
    List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) return result;
        Arrays.sort(nums);
        bt(result, new ArrayList<>(), 0, nums);
        return new ArrayList<>(result);
    }

    private void bt(List<List<Integer>> result, List<Integer> subset, int ind, int[] nums) {
        result.add(new ArrayList<>(subset));
        for (int i = ind; i < nums.length; i++) {
            if (i > ind && nums[i] == nums[i - 1]) {
                continue;
            }
            subset.add(nums[i]);
            bt(result, subset, i + 1, nums);
            subset.remove(subset.get(subset.size() - 1));
        }
    }
}
