package tree.BinaryTreePaths_257;

import javafx.util.Pair;
import tree.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 257. Binary Tree Paths
 * https://leetcode.com/problems/binary-tree-paths/
 *
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 *
 * A leaf is a node with no children.
 *
 * Example 1:
 * Input: root = [1,2,3,null,5]
 * Output: ["1->2->5","1->3"]
 *
 * Example 2:
 * Input: root = [1]
 * Output: ["1"]
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 100].
 * -100 <= Node.val <= 100
 */
public class Solution {
    // DFS, tc O(n), sc O(n)
    // 8 ms, faster than 57.07%; 38.7 MB, less than 99.11%
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, "", res);
        return res;
    }

    private void dfs(TreeNode root, String path, List<String> res) {
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
            return;
        }
        if (root.left != null) {
            dfs(root.left, path + root.val + "->", res);
        }
        if (root.right != null) {
            dfs(root.right, path + root.val + "->", res);
        }
    }

    // BFS, tc O(n), sc O(n)
    // 10ms, 39.5 MB
    public List<String> binaryTreePaths1(TreeNode root) {
        Queue<Pair<TreeNode, String>> q = new ArrayDeque<>();
        q.add(new Pair<>(root, ""));
        List<String> res = new ArrayList<>();
        while (!q.isEmpty()) {
            Pair<TreeNode, String> p = q.poll();
            TreeNode node = p.getKey();
            String s = p.getValue().isEmpty() ? "" + node.val : p.getValue() + "->" + node.val;
            if (node.left != null) {
                q.add(new Pair<>(node.left, s));
            }
            if (node.right != null) {
                q.add(new Pair<>(node.right, s));
            }
            if (node.left == null && node.right == null) {
                res.add(s);
            }
        }
        return res;
    }
}
