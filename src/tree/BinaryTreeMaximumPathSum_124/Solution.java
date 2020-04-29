package tree.BinaryTreeMaximumPathSum_124;

import tree.utils.TreeNode;

/**
 * 124. Binary Tree Maximum Path Sum
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 *
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to
 * any node in the tree along the parent-child connections. The path must contain at least
 * one node and does not need to go through the root.
 *
 * Example 1:
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 *
 * Example 2:
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 */
public class Solution {
    // tc O(n), sc O(logH) = O(logn) in worst case
    private int max;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        max = Integer.MIN_VALUE;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode tree) {
        if (tree == null) return 0;
        int left = dfs(tree.left);
        int right = dfs(tree.right);
        int curMax = Math.max(Math.max(tree.val, tree.val + left), tree.val + right);
        max = Math.max(Math.max(max, curMax), tree.val + left + right);
        return curMax;
    }
}
