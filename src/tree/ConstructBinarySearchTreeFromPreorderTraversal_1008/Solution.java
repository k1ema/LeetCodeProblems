package tree.ConstructBinarySearchTreeFromPreorderTraversal_1008;

import tree.utils.TreeNode;

/**
 * 1008. Construct Binary Search Tree from Preorder Traversal
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 *
 * Return the root node of a binary search tree that matches the given preorder traversal.
 *
 * (Recall that a binary search tree is a binary tree where for every node, any descendant
 * of node.left has a value < node.val, and any descendant of node.right has a value > node.val.
 * Also recall that a preorder traversal displays the value of the node first, then traverses
 * node.left, then traverses node.right.)
 *
 *
 * Example 1:
 *           8
 *          / \
 *         5   10
 *        / \    \
 *       1   7    12
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 *
 * Note:
 * 1 <= preorder.length <= 100
 * The values of preorder are distinct.
 */
public class Solution {
    // tc O(n), sc O(n)
    private int curInd;
    public TreeNode bstFromPreorder(int[] preorder) {
        curInd = 0;
        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode helper(int[] preorder, int min, int max) {
        if (curInd == preorder.length) return null;

        int val = preorder[curInd];
        if (val < min || val > max) return null;

        TreeNode node = new TreeNode(val);
        curInd++;
        node.left = helper(preorder, min, node.val);
        node.right = helper(preorder, min, node.val);
        return node;
    }

    // my solution
    // tc O(n), sc O(n)
    public TreeNode bstFromPreorder1(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        dfs(root, preorder, 1, null, null);
        return root;
    }

    private int dfs(TreeNode node, int[] preorder, int curInd, Integer min, Integer max) {
        if (curInd < 0 || curInd >= preorder.length) return -1;
        if (min != null && preorder[curInd] < min || max != null && preorder[curInd] > max) return curInd;

        if (preorder[curInd] < node.val) {
            node.left = new TreeNode(preorder[curInd]);
            curInd = dfs(node.left, preorder, curInd + 1, min, node.val);
        }

        if (curInd < 0 || curInd >= preorder.length) return -1;
        if (min != null && preorder[curInd] < min || max != null && preorder[curInd] > max) return curInd;

        if (preorder[curInd] > node.val) {
            node.right = new TreeNode(preorder[curInd]);
            curInd = dfs(node.right, preorder, curInd + 1, node.val, max);
        }

        return curInd;
    }
}
