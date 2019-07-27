package backtracking.Permutations_II_47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. Permutations II
 * https://leetcode.com/problems/permutations-ii/
 *
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 *
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class Solution {
    // tc O(n*n!), sc O(n)
    // https://leetcode.com/problems/permutations-ii/discuss/18594/Really-easy-Java-solution-much-easier-than-the-solutions-with-very-high-vote
    // https://leetcode.com/problems/permutations/discuss/18239/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning
    List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null) {
            return null;
        }
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, nums, new ArrayList<>(), new boolean[nums.length]);
        return list;
    }

    // in case of duplicates (a[i] == a[i-1]), we can use a[i] only if a[i-1] already used.
    // in other case duplicate sets be generated. like [1,2,1] [1,2,1].
    private void backtrack(List<List<Integer>> list, int[] nums, List<Integer> helper, boolean[] used) {
        if (helper.size() == nums.length) {
            list.add(new ArrayList<>(helper));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            helper.add(nums[i]);
            used[i] = true;
            backtrack(list, nums, helper, used);
            helper.remove(helper.size() - 1);
            used[i] = false;
        }
    }
}
