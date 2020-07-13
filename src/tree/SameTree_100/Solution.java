package tree.SameTree_100;

import tree.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 100. Same Tree
 * https://leetcode.com/problems/same-tree/
 *
 * Given two binary trees, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 * Example 1:
 *
 * Input:     1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * Output: true
 * Example 2:
 *
 * Input:     1         1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * Output: false
 * Example 3:
 *
 * Input:     1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * Output: false
 */
public class Solution {
    // tc O(n), sc O(n)
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == null && q == null;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // tc O(n), sc O(n) to keep queue for worst case - completely unbalanced tree
    // and O(logn) for the best case - completely balanced tree
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == null && q == null;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(p); q2.add(q);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode t1 = q1.poll();
            TreeNode t2 = q2.poll();
            if (!check(t1, t2) || !check(t1.left, t2.left) || !check(t1.right, t2.right)) return false;
            if (t1.left != null) q1.add(t1.left);
            if (t2.left != null) q2.add(t2.left);
            if (t1.right != null) q1.add(t1.right);
            if (t2.right != null) q2.add(t2.right);
        }
        return q1.isEmpty() && q2.isEmpty();
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == null && q == null;
        return p.val == q.val;
    }
}
