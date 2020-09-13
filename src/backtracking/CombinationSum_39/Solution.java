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
    /*
        tc O(N^(T/M + 1))),
            where N is the number of candidates, T is the target value, and M is the minimal value among the candidates.

            As we illustrated before, the execution of the backtracking is unfolded as a DFS traversal in a
            n-ary tree. The total number of steps during the backtracking would be the number of nodes in the tree.

            At each node, it takes a constant time to process, except the leaf nodes which could take a linear
            time to make a copy of combination. So we can say that the time complexity is linear to the number
            of nodes of the execution tree.

            Here we provide a loose upper bound on the number of nodes.

            First of all, the fan-out of each node would be bounded to NN, i.e. the total number of candidates.

            The maximal depth of the tree, would be T/M, where we keep on adding the smallest element to the combination.

            As we know, the maximal number of nodes in N-ary tree of T/M height would be N^{T/M+1}.

            Note that, the actual number of nodes in the execution tree would be much smaller than the upper bound,
            since the fan-out of the nodes are decreasing level by level.

        sc O(T/M)
            We implement the algorithm in recursion, which consumes some additional memory in the function call stack.

            The number of recursive calls can pile up to T/M, where we keep on adding the smallest element to the
            combination. As a result, the space overhead of the recursion is O(T/M)

            In addition, we keep a combination of numbers during the execution, which requires at most O(T/M) space as well.

            To sum up, the total space complexity of the algorithm would be O(T/M)

            Note that, we did not take into the account the space used to hold the final results for the space complexity.
    */
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
