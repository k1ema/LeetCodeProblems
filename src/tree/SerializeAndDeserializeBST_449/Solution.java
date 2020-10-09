package tree.SerializeAndDeserializeBST_449;

import tree.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 449. Serialize and Deserialize BST
 * https://leetcode.com/problems/serialize-and-deserialize-bst/
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that
 * it can be stored in a file or memory buffer, or transmitted across a network connection link to be
 * reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how
 * your serialization/deserialization algorithm should work. You just need to ensure that a binary search
 * tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * The encoded string should be as compact as possible.
 *
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize
 * algorithms should be stateless.
 */
public class Solution {
    // tc O(n), sc O(n)
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val);
                queue.add(node.left);
                queue.add(node.right);
            } else {
                sb.append("-");
            }
            sb.append(",");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        int i = 0;
        String[] s = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(s[i++]));
        q.add(root);
        while (!q.isEmpty() && i < s.length) {
            TreeNode node = q.poll();
            String val = s[i++];
            if (!val.equals("-")) {
                node.left = new TreeNode(Integer.parseInt(val));
                q.add(node.left);
            }
            val = s[i++];
            if (!val.equals("-")) {
                node.right = new TreeNode(Integer.parseInt(val));
                q.add(node.right);
            }
        }

        return root;
    }
}
