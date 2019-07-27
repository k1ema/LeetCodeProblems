package tree.DiameterOfBinaryTree_543;

import tree.utils.TreeNode;

/**
 * 543. Diameter of Binary Tree
 * https://leetcode.com/problems/diameter-of-binary-tree/
 *
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two
 * nodes in a tree. This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class Solution {
    private int max_diam = 0;

    // tc O(n), sc O(n)
    int diameterOfBinaryTree2(TreeNode root) {
        max_diam = 0;
        if (root == null) {
            return 0;
        }
        int left = diameterOfBinaryTree(root.left, 1);
        int right = diameterOfBinaryTree(root.right, 1);
        return Math.max(max_diam, left + right);
    }

    private int diameterOfBinaryTree(TreeNode root, int cur_diam) {
        if (root == null) {
            return cur_diam - 1;
        }
        int left = diameterOfBinaryTree(root.left, cur_diam + 1);
        int right = diameterOfBinaryTree(root.right, cur_diam + 1);
        max_diam = Math.max(max_diam, left + right - 2 * cur_diam);
        return Math.max(left, right);
    }

    // https://leetcode.com/problems/diameter-of-binary-tree/discuss/101132/Java-Solution-MaxDepth
    // O(n), O(n)
    private int max = 0;
    int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        depth(root);
        return max;
    }

    private int depth(TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        int l = depth(tree.left);
        int r = depth(tree.right);
        max = Math.max(max, l + r);
        return Math.max(l, r) + 1;
    }
}
