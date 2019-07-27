package tree.PathSum_III_437;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import tree.utils.TreeNode;

/**
 * 437. Path Sum III
 * https://leetcode.com/problems/path-sum-iii/
 *
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, but it must
 * go downwards (traveling only from parent nodes to child nodes).
 * The tree has no more than 1,000 nodes and the values are in the range
 * -1,000,000 to 1,000,000.
 *
 * Example:
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
public class Solution {
    private int result = 0;

    // tc O(nlogn), sc O(nlogn)
    int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        result = 0;
        checkSum(root, sum, Collections.emptyList());
        return result;
    }

    private void checkSum(TreeNode root, int sum, List<Integer> prevValues) {
        if (root == null) {
            return;
        }
        List<Integer> curValues = prevValues.stream().map(i -> i + root.val).collect(Collectors.toList());
        curValues.add(root.val);
        result += curValues.stream().filter(i -> i == sum).count();
        checkSum(root.left, sum, curValues);
        checkSum(root.right, sum, curValues);
    }

    // https://leetcode.com/problems/path-sum-iii/discuss/91878/17-ms-O(n)-java-Prefix-sum-method
    // tc O(n)
    int pathSum1(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0,1);
        return helper(root, 0, sum, preSum);
    }

    private int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }

        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }
}
