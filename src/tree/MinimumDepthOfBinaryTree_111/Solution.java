package tree.MinimumDepthOfBinaryTree_111;

import tree.utils.TreeNode;

/**
 * 111. Minimum Depth of Binary Tree
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Note: A leaf is a node with no children.
 * Example:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its minimum depth = 2.
 */
class Solution {
    // tc O(n), sc O(n)
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        return (l == 0 || r == 0) ? l + r + 1 : Math.min(l, r) + 1;
    }

    // tc O(n), sc O(n)
    public int minDepth1(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null && root.right != null) {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        } else if (root.left == null) {
            return 1 + minDepth(root.right);
        } else {
            return 1 + minDepth(root.left);
        }
    }
}
