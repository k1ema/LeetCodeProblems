package tree.MaximumDepthOfBinaryTree_104;

/**
 * 104. Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Note: A leaf is a node with no children.
 * Example:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 */

class Solution {
    int maxDepth(TreeNode root) {
        return depth(root);
    }

    private int depth(TreeNode tn) {
        if (tn == null) {
            return 0;
        }
        int dl = depth(tn.left);
        int dr = depth(tn.right);
        return Math.max(dl, dr) + 1;
    }
}
