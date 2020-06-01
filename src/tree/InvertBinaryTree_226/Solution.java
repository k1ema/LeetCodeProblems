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
    // recursion
    // tc O(n), sc O(n)
    TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode invert = new TreeNode(root.val);
        invert.left = invertTree(root.right);
        invert.right = invertTree(root.left);
        return invert;
    }

    // same approach
    // tc O(n), sc O(n)
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree1(root.left);
        invertTree1(root.right);
        return root;
    }

    // iterative
    // tc O(n), sc O(n)
    TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tree = queue.poll();
            TreeNode tmp = tree.left;
            tree.left = tree.right;
            tree.right = tmp;
            if (tree.left != null) queue.add(tree.left);
            if (tree.right != null) queue.add(tree.right);
        }
        return root;
    }
}
