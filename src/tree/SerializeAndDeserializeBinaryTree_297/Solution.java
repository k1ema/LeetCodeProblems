package tree.SerializeAndDeserializeBinaryTree_297;

import tree.utils.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 297. Serialize and Deserialize Binary Tree
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits
 * so that it can be stored in a file or memory buffer, or transmitted across a network
 * connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on
 * how your serialization/deserialization algorithm should work. You just need to ensure that
 * a binary tree can be serialized to a string and this string can be deserialized to the
 * original tree structure.
 *
 * Example:
 *
 * You may serialize the following tree:
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * as "[1,2,3,null,null,4,5]"
 * Clarification: The above format is the same as how LeetCode serializes a binary tree. You
 * do not necessarily need to follow this format, so please be creative and come up with
 * different approaches yourself.
 *
 * Note: Do not use class member/global/static variables to store states. Your serialize
 * and deserialize algorithms should be stateless.
 */
public class Solution {
    // The same solution as 449. Serialize and Deserialize BST (medium)
    // {@link tree.SerializeAndDeserializeBST_449.Solution}
    // https://leetcode.com/problems/serialize-and-deserialize-bst/

    // DFS, preorder traversal
    // 7 ms, faster than 93.53%; 40.8 MB, less than 6.10%

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("-,");
            return;
        }
        sb.append(root.val).append(",");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(nodes);
    }

    private TreeNode deserialize(Queue<String> nodes) {
        String n = nodes.poll();
        if (n.equals("-")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(n));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }

    // BFS
    // tc O(n), sc O(n)
    // 13 ms, faster than 53.56%; 41.8 MB, less than 6.10%

    // Encodes a tree to a single string.
    public String serialize1(TreeNode root) {
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

    public TreeNode deserialize1(String data) {
        if (data.isEmpty()) return null;

        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        String n = nodes.poll();
        if ("-".equals(n)) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(n));
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            String val = nodes.poll();
            if (!"-".equals(val)) {
                node.left = new TreeNode(Integer.parseInt(val));
                queue.add(node.left);
            }
            val = nodes.poll();
            if (!"-".equals(val)) {
                node.right = new TreeNode(Integer.parseInt(val));
                queue.add(node.right);
            }
        }

        return root;
    }
}
