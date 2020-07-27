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
    private int pIndex;
    private int[] postorder;
    private Map<Integer, Integer> inMap;
    TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || inorder.length != postorder.length) return null;
        pIndex = postorder.length - 1;

        this.postorder = postorder;

        inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return helper(0, postorder.length - 1);
    }

    private TreeNode helper(int left, int right) {
        if (left > right) return null;
        TreeNode root = new TreeNode(postorder[pIndex]);
        int inIndex = inMap.get(postorder[pIndex]);
        pIndex--;
        root.right = helper(inIndex + 1, right);
        root.left = helper(left, inIndex - 1);
        return root;
    }
}
