package tree.SumOfLeftLeaves_404;

import javafx.util.Pair;
import tree.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 404. Sum of Left Leaves
 * https://leetcode.com/problems/sum-of-left-leaves/
 *
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class Solution {
    // DFS
    // tc O(n), sc O(n)
    // 0 ms; 38 MB
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

    private int dfs(TreeNode root, boolean left) {
        if (root == null) return 0;
        if (root.left == null && root.right == null && left) return root.val;
        return dfs(root.left, true) + dfs(root.right, false);
    }

    // BFS
    // tc O(n), sc O(n)
    // 1 ms, faster than 20.95%; 37.8 MB, less than 44.80%
    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair<TreeNode, Boolean>> q = new LinkedList<>();
        q.add(new Pair<>(root, false));
        int res = 0;
        while (!q.isEmpty()) {
            Pair<TreeNode, Boolean> pair = q.poll();
            TreeNode tree = pair.getKey();
            boolean leftNode = pair.getValue();
            if (leftNode && tree.left == null && tree.right == null) res += tree.val;
            if (tree.left != null) q.add(new Pair<>(tree.left, true));
            if (tree.right != null) q.add(new Pair<>(tree.right, false));
        }
        return res;
    }
}
