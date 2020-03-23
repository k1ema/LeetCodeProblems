package tree.ValidateBinarySearchTree_98;

import tree.utils.TreeNode;

import java.util.Stack;

/**
 * 98. Validate Binary Search Tree
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Example 1:
 *     2
 *    / \
 *   1   3
 * Input: [2,1,3]
 * Output: true
 *
 * Example 2:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class Solution {
    // tc O(n), sc O(depth). If tree is balanced then depth = logn. In worst case depth = n.
    // 0 ms, faster than 100.00%; 38.2 MB, less than 86.51%
    boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;

        if (min != null && root.val <= min || max != null && root.val >= max) return false;

        boolean left = helper(root.left, min, root.val);
        boolean right = helper(root.right, root.val, max);

        return left && right;
    }

    // my solution
    // tc O(n), sc O(n)
    // 0 ms, faster than 100.00%; 39.2 MB, less than 80.93%
    private boolean result;
    boolean isValidBST1(TreeNode root) {
        if (root == null) return true;
        result = true;
        dfs(root);
        return result;
    }

    private int[] dfs(TreeNode root) {
        if (root == null || !result) return null;
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        if (left != null && left[1] >= root.val || right != null && right[0] <= root.val) {
            result = false;
        }
        int min = root.val, max = root.val;
        if (left != null) {
            min = Math.min(min, left[0]);
        }
        if (right != null) {
            max = Math.max(max, right[1]);
        }
        return new int[] {min, max};
    }

    // https://discuss.leetcode.com/topic/7179/my-simple-java-solution-in-3-lines
    // https://en.wikipedia.org/wiki/Binary_search_tree - tree validation
    // The main idea is node value should be  min<val<max, how to get min and max?
    // for left node - min = parent.min, max = parent.value
    // for right node - min = parent.value, max = parent.max
    public boolean isValidBST2(TreeNode root) {
        return isValidRecursive(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidRecursive(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (min < root.val && root.val < max) {
            return isValidRecursive(root.left, min, root.val) && isValidRecursive(root.right, root.val, max);
        }
        return false;
    }

    // Iterative solution
    // https://discuss.leetcode.com/topic/46016/learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-java-solution
    // Recursive solution
    // https://discuss.leetcode.com/topic/4659/c-in-order-traversal-and-please-do-not-rely-on-buggy-int_max-int_min-solutions-any-more
    // Main idea is next: we can traverse tree from the min element to max.
    // The most left leaf - is min, the most right leaf - is max.
    // In each iteration we check that current<prev. For the min el - prev is null.
    public boolean isValidBST3(TreeNode root) {
        if (root == null) return true;
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            // go to the most left el
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode curr = stack.pop();
            if (prev != null && curr.val <= prev.val) return false;
            prev = curr;
            root = curr.right;
        }
        return true;
    }
}
