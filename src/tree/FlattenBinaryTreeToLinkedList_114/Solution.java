package tree.FlattenBinaryTreeToLinkedList_114;

import tree.utils.TreeNode;

/**
 * 114. Flatten Binary Tree to Linked List
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 *
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class Solution {
    // tc O(n), sc O(1), 0 ms, faster than 100.00%; 38.6 MB, less than 38.18%
    // https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/37010/share-my-simple-non-recursive-solution-o1-space-complexity
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode leftBranch = curr.left;
                while (leftBranch.right != null) {
                    leftBranch = leftBranch.right;
                }

                leftBranch.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    // my solution
    // tc O(n), sc O(n)
    // 1 ms, faster than 30.03%; 40.8 MB, less than 5.45%
    public void flatten2(TreeNode root) {
        if (root == null) return;
        TreeNode right = root.right;
        TreeNode left = dfs(root.left, root);
        dfs(right, left);
    }

    private TreeNode dfs(TreeNode cur, TreeNode tree) {
        if (cur == null) return tree;
        tree.right = new TreeNode(cur.val);
        tree.left = null;
        TreeNode left = dfs(cur.left, tree.right);
        return dfs(cur.right, left);
    }

    // tc O(n), sc O(n) (because of recursion)
    // 0 ms, faster than 100.00%; 37.9 MB, less than 58.18%
    // https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/36977/My-short-post-order-traversal-Java-solution-for-share
    // visit nodes starting from the right side, e.g 6-5-4-3-2-1
    TreeNode prev;
    public void flatten1(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}