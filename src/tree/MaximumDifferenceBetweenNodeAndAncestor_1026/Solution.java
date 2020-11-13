package tree.MaximumDifferenceBetweenNodeAndAncestor_1026;

import tree.utils.TreeNode;

/**
 * 1026. Maximum Difference Between Node and Ancestor
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 *
 * Given the root of a binary tree, find the maximum value V for which there exist
 * different nodes A and B where V = |A.val - B.val| and A is an ancestor of B.
 *
 * A node A is an ancestor of B if either: any child of A is equal to B, or any child
 * of A is an ancestor of B.
 *
 * Example 1:
 * Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
 * Output: 7
 * Explanation: We have various ancestor-node differences, some of which are given below :
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
 *
 * Example 2:
 * Input: root = [1,null,2,null,0,3]
 * Output: 3
 *
 * Constraints:
 * The number of nodes in the tree is in the range [2, 5000].
 * 0 <= Node.val <= 105
 */
public class Solution {
    // tc O(n), sc O(n)
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode root, int min, int max) {
        if (root == null) return max - min;
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        int anc = Math.max(dfs(root.left, min, max), dfs(root.right, min, max));
        return Math.max(anc, max - min);
    }

    // the same approach but using global var
    // tc O(n), sc O(n)
    private int res;
    public int maxAncestorDiff1(TreeNode root) {
        res = 0;
        dfs1(root, root.val, root.val);
        return res;
    }

    private void dfs1(TreeNode root, int min, int max) {
        if (root == null) return;
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        res = Math.max(res, Math.abs(max - min));
        dfs1(root.left, min, max);
        dfs1(root.right, min, max);
    }
}
