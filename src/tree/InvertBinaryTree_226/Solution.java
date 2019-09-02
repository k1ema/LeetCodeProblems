package tree.InvertBinaryTree_226;

import tree.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 226. Invert Binary Tree
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * Invert a binary tree.
 *
 * Example:
 * Input:
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * Output:
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class Solution {
    // tc O(n), sc O(n)
    // recursion
    TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode invert = new TreeNode(root.val);
        invert.left = invertTree(root.right);
        invert.right = invertTree(root.left);
        return invert;
    }

    // tc O(n), sc O(n)
    // iterative
    TreeNode invertTree1(TreeNode root) {
        Queue<TreeNode> tree = new LinkedList<>();
        tree.add(root);
        while (!tree.isEmpty()) {
            TreeNode st = tree.poll();
            if (st == null) {
                continue;
            }
            TreeNode tmp = st.left;
            st.left =  st.right;
            st.right = tmp;
            tree.add(st.left);
            tree.add(st.right);
        }
        return root;
    }
}
