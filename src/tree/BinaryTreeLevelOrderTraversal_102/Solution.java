package tree.BinaryTreeLevelOrderTraversal_102;

import tree.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class Solution {
    // bfs, tc O(n), sc O(n)
    // 0 ms, faster than 100.00%; 39.8 MB, less than 43.77%
    List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tree = q.poll();
                level.add(tree.val);
                if (tree.left != null) q.add(tree.left);
                if (tree.right != null) q.add(tree.right);
            }
            res.add(level);
        }
        return res;
    }

    // dfs, tc O(n), sc O(n)
    // 0 ms, faster than 100.00%; 36.2 MB, less than 100.00%
    List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, root, 0);
        return result;
    }

    private void dfs(List<List<Integer>> list, TreeNode node, int level) {
        if (node == null) return;
        if (level >= list.size()) list.add(new ArrayList<>());
        if (node.left != null) dfs(list, node.left, level + 1);
        if (node.right != null) dfs(list, node.right, level + 1);
        list.get(level).add(node.val);
    }
}
