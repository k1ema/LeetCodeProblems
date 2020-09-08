package tree.SumOfRootToLeafBinaryNumbers_1022;

import javafx.util.Pair;
import tree.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1022. Sum of Root To Leaf Binary Numbers
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 *
 * Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents
 * a binary number starting with the most significant bit.  For example, if the path is
 * 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
 *
 * For all leaves in the tree, consider the numbers represented by the path from the
 * root to that leaf.
 *
 * Return the sum of these numbers.
 *
 * Example 1:
 *              1
 *            /   \
 *           0     1
 *          / \   / \
 *         0   1 0   1
 *
 * Input: [1,0,1,0,1,0,1]
 * Output: 22
 * Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 *
 * Note:
 * The number of nodes in the tree is between 1 and 1000.
 * node.val is 0 or 1.
 * The answer will not exceed 2^31 - 1.
 */
public class Solution {
    // tc O(n), sc O(h)
    // 0 ms, faster than 100.00%; 39.3 MB, less than 52.96%
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int num) {
        if (root == null) return 0;
        num = num << 1 | root.val; // num = num * 2 + root.val
        return root.left == null && root.right == null ? num : dfs(root.left, num) + dfs(root.right, num);
    }

    // BFS
    // tc O(n), sc O(n)
    // 1 ms, faster than 50.03%; 38.7 MB, less than 94.14%
    public int sumRootToLeaf2(TreeNode root) {
        if (root == null) return 0;
        Deque<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        queue.add(new Pair<>(root, 0));
        int res = 0;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> p = queue.poll();
            TreeNode tree = p.getKey();
            int cur = p.getValue() << 1 | tree.val;
            if (tree.left == null && tree.right == null) {
                res += cur;
            } else {
                if (tree.left != null) queue.add(new Pair<>(tree.left, cur));
                if (tree.right != null) queue.add(new Pair<>(tree.right, cur));
            }
        }
        return res;
    }

    // tc O(n), sc O(h)
    public int sumRootToLeaf3(TreeNode root) {
        return root == null ? 0 : dfs(root, new StringBuilder());
    }

    private int dfs(TreeNode root, StringBuilder sb) {
        if (root == null) return 0;
        sb.append(root.val);
        int res;
        if (root.left == null && root.right == null) {
            res = Integer.parseInt(sb.toString(), 2);
        } else {
            res = dfs(root.left, sb) + dfs(root.right, sb);
        }
        sb.deleteCharAt(sb.length() - 1);
        return res;
    }
}