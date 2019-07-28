package tree.ConstructBinaryTreeFromPreorderAndInorderTraversal_105;

import java.util.HashMap;
import java.util.Map;

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
    // https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
    // explanation https://www.techiedelight.com/construct-binary-tree-from-inorder-preorder-traversal/
    // The the basic idea is to take the first element in preorder array as the root, find the position
    // of the root in the inorder array; then locate the range for left sub-tree and right sub-tree and
    // do recursion. Use a HashMap to record the index of root in the inorder array.
    TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null
                || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }

        Map<Integer, Integer> inorderIndexes = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexes.put(inorder[i], i);
        }

        return buildTree(0, inorder.length - 1, inorderIndexes, 0, preorder);
    }

    private TreeNode buildTree(int start, int end, Map<Integer, Integer> inorderIndexes, int pIndex, int[] preorder) {
        if (start > end) {
            return null;
        }
        int rootVal = preorder[pIndex];
        TreeNode root = new TreeNode(rootVal);
        int index = inorderIndexes.get(rootVal);
        int leftLength = index - start;
        root.left = buildTree(start,  index - 1, inorderIndexes, pIndex + 1, preorder);
        root.right = buildTree(index + 1, end, inorderIndexes, pIndex + 1 + leftLength, preorder);
        return root;
    }
}