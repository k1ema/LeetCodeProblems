package tree.ConstructBinaryTreeFromPreorderAndPostorderTraversal_889;

import java.util.HashMap;
import java.util.Map;

import tree.utils.TreeNode;

/**
 * 889. Construct Binary Tree from Preorder and Postorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 *
 * Return any binary tree that matches the given preorder and postorder traversals.
 *
 * Values in the traversals pre and post are distinct positive integers.
 *
 * Example 1:
 * Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * Output: [1,2,3,4,5,6,7]
 *
 * Note:
 * 1 <= pre.length == post.length <= 30
 * pre[] and post[] are both permutations of 1, 2, ..., pre.length.
 * It is guaranteed an answer exists. If there exists multiple answers, you can return any of them.
 */
public class Solution {
    // https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/discuss/161372/Java-Python-Divide-and-Conquer-with-Explanation
    // tc O(n), sc O(n)
    TreeNode constructFromPrePost(int[] pre, int[] post) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < post.length; i++) {
            map.put(post[i], i);
        }

        return dfs(pre, 0, pre.length - 1, 0, post.length - 1, map);
    }

    private TreeNode dfs(int[] pre, int preStart, int preEnd, int postStart, int postEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd || postStart > postEnd) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preStart]);
        if (preStart == preEnd) {
            return root;
        }

        int postInd = map.get(pre[preStart + 1]);
        int leftSubTreeLen = postInd - postStart + 1;
        root.left = dfs(pre, preStart + 1, preStart + leftSubTreeLen, postStart, postInd, map);
        root.right = dfs(pre, preStart + 1 + leftSubTreeLen, preEnd, postInd + 1, postEnd - 1, map);
        return root;
    }
}
