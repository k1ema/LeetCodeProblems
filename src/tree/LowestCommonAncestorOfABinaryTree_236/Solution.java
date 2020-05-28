package tree.LowestCommonAncestorOfABinaryTree_236;

import tree.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined
 * between two nodes p and q as the lowest node in T that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).”
 *
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * Example 1:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 *
 * Example 2:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself
 * according to the LCA definition.
 *
 * Note:
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
 */
public class Solution {
    // tc O(n), sc O(n)
    // 5 ms, faster than 100.00%; 35.9 MB, less than 5.55%
    // https://discuss.leetcode.com/topic/18561/4-lines-c-java-python-ruby
    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.equals(p) || root.equals(q)) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : (right == null ? left : root);
    }

    // tc O(n), sc O(n)
    // 5 ms, faster than 100.00%; 35.2 MB, less than 5.55%
    private TreeNode ans;
    TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val == q.val) return p;
        ans = null;
        dfs(root, p.val, q.val);
        return ans;
    }

    private boolean dfs(TreeNode root, int p, int q) {
        if (root == null) return false;
        int mid = root.val == p || root.val == q ? 1 : 0;
        int left = dfs(root.left, p, q) ? 1 : 0;
        int right = dfs(root.right, p, q) ? 1 : 0;
        if (left + right + mid >= 2) {
            ans = root;
        }
        return left + right + mid >= 1;
    }

    // my solution
    // tc O(n), sc O(n)
    // 6 ms, faster than 71.20%; 35.6 MB, less than 5.55%
    TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val == q.val) return p;
        Queue<TreeNode> trackP = new LinkedList<>();
        Queue<TreeNode> trackQ = new LinkedList<>();
        dfs1(root, trackP, p.val);
        dfs1(root, trackQ, q.val);
        while (!trackP.isEmpty()) {
            TreeNode node = trackP.poll();
            if (trackQ.contains(node)) return node;
        }
        return root;
    }

    private boolean dfs1(TreeNode root, Queue<TreeNode> track, int val) {
        if (root == null) return false;
        if (root.val == val) {
            track.add(root);
            return true;
        }
        boolean b1 = dfs1(root.left, track, val);
        boolean b2 = dfs1(root.right, track, val);
        if (b1 || b2) track.add(root);
        return b1 || b2;
    }
}
