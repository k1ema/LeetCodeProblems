package tree.BinaryTreeLevelOrderTraversal_II_107;

import javafx.util.Pair;
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
    // dfs, tc O(n), sc O(n)
    // 0 ms, faster than 100.00%; 36.3 MB, less than 100.00%
    List<List<Integer>> levelOrderBottom(TreeNode root) {
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

    // bfs
    // 1 ms, faster than 99.52%; 36.6 MB, less than 100.00%
    List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            result.add(0, list);
        }
        return result;
    }

    // my solution
    // bfs, tc O(n), sc O(n)
    // 1 ms, faster than 99.52%; 36.3 MB, less than 100.00%
    List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Pair<Integer, TreeNode>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, root));
        while (!queue.isEmpty()) {
            Pair<Integer, TreeNode> pair = queue.poll();
            int level = pair.getKey();
            if (level >= result.size()) {
                result.add(0, new ArrayList<>());
            }
            TreeNode node = pair.getValue();
            if (node.left != null) {
                queue.add(new Pair<>(level + 1, node.left));
            }
            if (node.right != null) {
                queue.add(new Pair<>(level + 1, node.right));
            }
            result.get(result.size() - level - 1).add(node.val);
        }
        return result;
    }
}
