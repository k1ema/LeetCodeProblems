package tree.BinaryTreeLevelOrderTraversal_II_107;

import tree.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. Binary Tree Level Order Traversal II
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 *
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class Solution {
    // bfs
    // 1 ms, faster than 99.52%; 36.6 MB, less than 100.00%
    List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> stack = new LinkedList<>();
        if (root == null) return stack;
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
            stack.push(level);
        }
        return stack;
    }

    // dfs, tc O(n), sc O(n)
    // 0 ms, faster than 100.00%; 36.3 MB, less than 100.00%
    List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, root, 0);
        return result;
    }

    private void helper(List<List<Integer>> list, TreeNode root, int level) {
        if (root == null) return;
        if (level >= list.size()) list.add(0, new ArrayList<>());
        helper(list, root.left, level + 1);
        helper(list, root.right, level + 1);
        list.get(list.size() - level - 1).add(root.val);
    }
}
