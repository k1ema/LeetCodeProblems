package tree.DeleteNodeInaBST_450;

import tree.utils.TreeNode;

/**
 * 450. Delete Node in a BST
 * https://leetcode.com/problems/delete-node-in-a-bst/
 *
 * Given a root node reference of a BST and a key, delete the node with the given
 * key in the BST. Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 * Search for a node to remove.
 * If the node is found, delete the node.
 * Note: Time complexity should be O(height of tree).
 *
 * Example:
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 *
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 *
 * Another valid answer is [5,2,6,null,4,null,7].
 *     5
 *    / \
 *   2   6
 *    \   \
 *     4   7
 */
public class Solution {
    // tc O(h), sc O(h)
    // 0 ms, faster than 100.00%; 40.1 MB, less than 17.24%
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        return dfs(root, key);
    }

    private TreeNode dfs(TreeNode tree, int key) {
        if (tree == null) return null;
        if (tree.val == key) {
            if (tree.left == null || tree.right == null) {
                return tree.left != null ? tree.left : tree.right;
            }
            TreeNode newNode = tree.right;
            TreeNode tmp = newNode;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            tmp.left = tree.left;
            return newNode;
        } else if (tree.val < key) {
            tree.right = dfs(tree.right, key);
        } else {
            tree.left = dfs(tree.left, key);
        }
        return tree;
    }
}
