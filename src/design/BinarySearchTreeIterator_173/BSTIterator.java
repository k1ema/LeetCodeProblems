package design.BinarySearchTreeIterator_173;

import tree.utils.TreeNode;

import java.util.Stack;

/**
 * 173. Binary Search Tree Iterator
 * https://leetcode.com/problems/binary-search-tree-iterator/
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the
 * root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 * Example:
 *           7
 *         /   \
 *        3    15
 *       / \   / \
 *      1   4 10 20
 *
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // return 3
 * iterator.next();    // return 7
 * iterator.hasNext(); // return true
 * iterator.next();    // return 9
 * iterator.hasNext(); // return true
 * iterator.next();    // return 15
 * iterator.hasNext(); // return true
 * iterator.next();    // return 20
 * iterator.hasNext(); // return false
 *
 * Note:
 * next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of
 * the tree.
 * You may assume that next() call will always be valid, that is, there will be at least a next smallest
 * number in the BST when next() is called.
 */
public class BSTIterator {
    // 16 ms, faster than 89.72%; 44.8 MB, less than 100.00%
    private Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        leftMostInorder(root);
    }

    private void leftMostInorder(TreeNode tree) {
        while (tree != null) {
            stack.push(tree);
            tree = tree.left;
        }
    }

    /** @return the next smallest number */
    // tc O(1); sc O(h)
    public int next() {
        if (!stack.isEmpty()) {
            TreeNode tree = stack.pop();
            leftMostInorder(tree.right);
            return tree.val;
        } else {
            return -1;
        }
    }

    /** @return whether we have a next smallest number */
    // tc O(1); sc O(h)
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
