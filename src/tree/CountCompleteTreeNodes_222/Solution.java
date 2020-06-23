package tree.CountCompleteTreeNodes_222;

import tree.utils.TreeNode;

/**
 * 222. Count Complete Tree Nodes
 * https://leetcode.com/problems/count-complete-tree-nodes/
 *
 * Given a complete binary tree, count the number of nodes.
 *
 * Note:
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled,
 * and all nodes in the last level are as far left as possible. It can have between 1 and 2h
 * nodes inclusive at the last level h.
 *
 * Example:
 * Input:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 * Output: 6
 */
public class Solution {
    // https://leetcode.com/problems/count-complete-tree-nodes/discuss/61958/Concise-Java-solutions-O(log(n)2)
    // tc O(log(n)^2)
    int countNodes4(TreeNode root) {
        int h = height(root);
        if (h < 0) {
            return 0;
        } else {
            if (height(root.right) == h - 1) {
                return (1 << h) + countNodes(root.right);
            } else {
                return (1 << (h - 1)) + countNodes(root.left);
            }
        }
    }

    // tc O(log(n)^2)
    int countNodes(TreeNode root) {
        int l = depth(root, true);
        int r = depth(root, false);
        return l == r ? (1 << l) - 1 : 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int depth(TreeNode node, boolean left) {
        if (node == null) return 0;
        int d = 0;
        while (node != null) {
            node = left ? node.left : node.right;
            d++;
        }
        return d;
    }

    // iterative
    // tc O(log(n)^2)
    int countNodes2(TreeNode root) {
        int h = height(root);
        int nodes = 0;
        while (root != null) {
            if (height(root.right) == h - 1) {
                nodes += 1 << h;
                root = root.right;
            } else {
                nodes += 1 << (h - 1);
                root = root.left;
            }
            h--;
        }
        return nodes;
    }

    private int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }

    // my solution
    // tc O(n), sc O(1)
    int countNodes3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = countNodes2(root.left);
        int r = countNodes2(root.right);
        return 1 + l + r;
    }
}