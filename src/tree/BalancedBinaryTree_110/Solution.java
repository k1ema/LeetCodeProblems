package tree.BalancedBinaryTree_110;

import tree.utils.TreeNode;

/**
 * 110. Balanced Binary Tree
 * https://leetcode.com/problems/balanced-binary-tree/
 *
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example 1:
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 *
 * Example 2:
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Return false.
 *
 * Good description
 * https://discuss.leetcode.com/topic/7798/the-bottom-up-o-n-solution-would-be-better
 */

class Solution {
    private boolean isBalanced = true;

    boolean isBalanced(TreeNode root) {
        isBalanced = true;
        depth(root);
        return isBalanced;
    }

    private int depth(TreeNode tn) {
        if (tn == null) {
            return 0;
        }
        int l = depth(tn.left);
        int r = depth(tn.right);
        if (Math.abs(l - r) > 1) {
            isBalanced = false;
        }
        return Math.max(l, r) + 1;
    }
}
