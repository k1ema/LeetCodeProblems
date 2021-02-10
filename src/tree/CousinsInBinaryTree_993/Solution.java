package tree.CousinsInBinaryTree_993;

import tree.utils.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 993. Cousins in Binary Tree
 * https://leetcode.com/problems/cousins-in-binary-tree/
 *
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 *
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 *
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 *
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 *
 * Example 1:
 *            1
 *           / \
 *          2   3
 *         /
 *        4
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 *
 * Example 2:
 *            1
 *           / \
 *          2   3
 *           \   \
 *            4   5
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 *
 * Example 3:
 *            1
 *           / \
 *          2   3
 *           \
 *            4
 *
 * Input: root = [1,2,3,null,4], x = 2, y = 3
 * Output: false
 *
 * Note:
 * The number of nodes in the tree will be between 2 and 100.
 * Each node has a unique integer value from 1 to 100.
 */
public class Solution {
    // DFS tc O(n), sc O(n)
    private TreeNode parentX, parentY;
    private int xDepth, yDepth;
    public boolean isCousins(TreeNode root, int x, int y) {
        parentX = null; parentY = null;
        xDepth = 0; yDepth = 0;
        dfs(root, x, y, 0, null);
        return parentX != parentY && xDepth == yDepth;
    }

    private void dfs(TreeNode node, int x, int y, int depth, TreeNode parent) {
        if (node == null) return;
        if (node.val == x) {
            parentX = parent;
            xDepth = depth;
            return;
        }
        if (node.val == y) {
            parentY = parent;
            yDepth = depth;
            return;
        }
        dfs(node.left, x, y, depth + 1, node);
        dfs(node.right, x, y, depth + 1, node);
    }

    // BFS
    // tc O(n), sc O(n)
    public boolean isCousins1(TreeNode root, int x, int y) {
        if (root == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            boolean xExist = false, yExist = false;
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.val == x) xExist = true;
                if (cur.val == y) yExist = true;
                if (cur.left != null && cur.right != null) {
                    if (cur.left.val == x && cur.right.val == y
                            || cur.left.val == y && cur.right.val == x) {
                        return false;
                    }
                }
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            if (xExist && yExist) return true;
        }
        return false;
    }

    // DFS my solution tc O(n), sc O(n)
    private Map<Integer, int[]> map;
    public boolean isCousins2(TreeNode root, int x, int y) {
        map = new HashMap<>();
        dfs(root, x, 0);
        dfs(root, y, 0);
        if (map.size() != 2 || !map.containsKey(x) || !map.containsKey(y)) return false;
        int[] xx = map.get(x);
        int[] yy = map.get(y);
        return xx[0] == yy[0] && xx[1] != yy[1];
    }

    private int dfs(TreeNode node, int x, int depth) {
        if (node == null) return -1;
        if (node.val == x) {
            map.put(x, new int[] {depth, -1});
            return depth;
        }
        int left = dfs(node.left, x, depth + 1);
        int right = dfs(node.right, x, depth + 1);
        if (left > 0 || right > 0) {
            int[] value = map.get(x);
            value[1] = node.val;
            map.put(x, value);
        }
        return -1;
    }
}
