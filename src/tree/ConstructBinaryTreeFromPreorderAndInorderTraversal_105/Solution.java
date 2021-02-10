package tree.ConstructBinaryTreeFromPreorderAndInorderTraversal_105;

import tree.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

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
    private int preIndex;
    private Map<Integer, Integer> inMap;
    private int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || preorder.length != inorder.length) return null;
        preIndex = 0;
        this.preorder = preorder;
        inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return helper(0, inorder.length - 1);
    }

    private TreeNode helper(int left, int right) {
        if (left > right) return null;
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        int inIndex = inMap.get(rootVal);
        root.left = helper(left, inIndex - 1);
        root.right = helper(inIndex + 1, right);
        return root;
    }

    // tc O(n), sc O(n)
    // https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
    // explanation https://www.techiedelight.com/construct-binary-tree-from-inorder-preorder-traversal/
    // The the basic idea is to take the first element in preorder array as the root, find the position
    // of the root in the inorder array; then locate the range for left sub-tree and right sub-tree and
    // do recursion. Use a HashMap to record the index of root in the inorder array.
    TreeNode buildTree1(int[] preorder, int[] inorder) {
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
