package tree.ConstructBinaryTreeFromInorderAndPostorderTraversal_106;

import java.util.HashMap;
import java.util.Map;

import tree.utils.TreeNode;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
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
    // solution same as
    // https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/discuss/34782/My-recursive-Java-code-with-O(n)-time-and-O(n)-space
    // The the basic idea is to take the last element in postorder array as the root, find the position
    // of the root in the inorder array; then locate the range for left sub-tree and right sub-tree and
    // do recursion. Use a HashMap to record the index of root in the inorder array.
    TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null
                || inorder.length == 0 || postorder.length != inorder.length) {
            return null;
        }

        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return construct(inMap, postorder.length - 1, 0, inorder.length - 1, postorder);
    }

    private TreeNode construct(Map<Integer, Integer> inMap, int pIndex, int left, int right, int[] postorder) {
        if (left > right) {
            return null;
        }

        int rootVal = postorder[pIndex];
        TreeNode root = new TreeNode(rootVal);
        int inIndex = inMap.get(rootVal);
        int rightLength = right - inIndex;
        root.right = construct(inMap, pIndex - 1, inIndex + 1, right, postorder);
        root.left = construct(inMap, pIndex - 1 - rightLength, left, inIndex - 1, postorder);
        return root;
    }
}
