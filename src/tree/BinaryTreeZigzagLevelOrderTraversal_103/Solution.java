package tree.BinaryTreeZigzagLevelOrderTraversal_103;

import tree.utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from
 * left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class Solution {
    // BFS, tc O(n), sc O(n)
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        boolean reverse = false;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            if (reverse) Collections.reverse(list);
            res.add(list);
            reverse = !reverse;
        }
        return res;
    }

    // DFS, tc O(n), sc O(n)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode node, int level, List<List<Integer>> res) {
        if (level == res.size()) {
            res.add(new LinkedList<>());
            res.get(res.size() - 1).add(node.val);
        } else {
            if (level % 2 == 0) {
                res.get(level).add(node.val);
            } else {
                res.get(level).add(0, node.val);
            }
        }
        if (node.left != null) dfs(node.left, level + 1, res);
        if (node.right != null) dfs(node.right, level + 1, res);
    }
}