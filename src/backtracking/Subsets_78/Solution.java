package backtracking.Subsets_78;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 * https://leetcode.com/problems/subsets/
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Solution {
    // https://leetcode.com/problems/subsets/discuss/122645/3ms-easiest-solution-no-backtracking-no-bit-manipulation-no-dfs-no-bullshit
    // tc O(n * 2^n), sc O(2^n),
    // it is a geometric progression: n + 2n + 4n + 8n + ... ~ 2^n
    // or in another way: having each number we have two choices:
    // to include the number or to exclude it. so, we have 2*2*2...*2 (n times) = 2^n
    // and n - is the time of copying n-size of subset to the result list
    List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> subset = new ArrayList<>(result.get(j));
                subset.add(nums[i]);
                result.add(subset);
            }
        }

        return result;
    }

    // backtracking, same as in permutations_46 or combinations_77
    // https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
    // https://www.youtube.com/watch?v=3dEVYiyFKac
    // tc O(n * 2^n), n - is the time of copying n-size of list to the result list
    // sc O(2^n)
    List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        bt(result, new ArrayList<>(), 0, nums);
        return result;
    }

    private void bt(List<List<Integer>> result, List<Integer> tmpList, int ind, int[] nums) {
        result.add(new ArrayList<>(tmpList));
        for (int i = ind; i < nums.length; i++) {
            tmpList.add(nums[i]);
            bt(result, tmpList, i + 1, nums);
            tmpList.remove(tmpList.get(tmpList.size() - 1));
        }
    }
}
