package tree.ConstructBinaryTreeFromPreorderAndInorderTraversal_105;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import tree.utils.TreeNode;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class Solution {
    // tc O(n), sc O(n)
    TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null
                || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }

        Map<Integer, Integer> inorderIndexes = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexes.put(inorder[i], i);
        }

        return buildTree(0, inorder.length - 1, inorderIndexes, new AtomicInteger(0), preorder);
    }

    private TreeNode buildTree(int start, int end, Map<Integer, Integer> inorderIndexes, AtomicInteger pIndex, int[] preorder) {
        if (start > end) {
            return null;
        }
        int rootVal = preorder[pIndex.getAndIncrement()];
        TreeNode root = new TreeNode(rootVal);
        int index = inorderIndexes.get(rootVal);
        root.left = buildTree(start,  index - 1, inorderIndexes, pIndex, preorder);
        root.right = buildTree(index + 1, end, inorderIndexes, pIndex, preorder);
        return root;
    }
}
