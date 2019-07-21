package stack.BinaryTreeInorderTraversal_94;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import tree.utils.TreeNode;

/**
 * 94. Binary Tree Inorder Traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class Solution {
    // tc O(n), sc O(n)
    List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();

        goLeft(root, stack);

        if (stack.isEmpty()) {
            goLeft(root.right, stack);
        }

        while (!stack.isEmpty()) {
            TreeNode tn = stack.pop();
            result.add(tn.val);

            goLeft(tn.right, stack);
        }

        return result;
    }

    private void goLeft(TreeNode root, Stack<TreeNode> stack) {
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
    }

    // https://leetcode.com/problems/binary-tree-inorder-traversal/discuss/31213/Iterative-solution-in-Java-simple-and-readable
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }

    // recursive
    // tc O(n), sc O(n)
    List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}
