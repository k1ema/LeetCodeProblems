package tree.InvertBinaryTree_226;

import java.util.LinkedList;
import java.util.Queue;

import tree.utils.TreeNode;

/**
 * 226. Invert Binary Tree
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
    TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    // tc O(n), sc O(n)
    // iterative
    TreeNode invertTree(TreeNode root) {
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
