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
        dfs(preorder, 1, root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return root;
    }

    private int dfs(int[] preorder, int ind, TreeNode parent, int min, int max) {
        if (ind == -1 || ind == preorder.length) return -1;
        int curVal = preorder[ind];
        if (curVal < parent.val && curVal > min && curVal < max) {
            parent.left = new TreeNode(curVal);
            ind = dfs(preorder, ind + 1, parent.left, min, parent.val);
        }
        if (ind != -1) {
            curVal = preorder[ind];
            if (curVal > parent.val && curVal > min && curVal < max) {
                parent.right = new TreeNode(curVal);
                ind = dfs(preorder, ind + 1, parent.right, parent.val, max);
            }
        }
        return ind;
    }
}
