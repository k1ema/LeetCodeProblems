package tree.SerializeAndDeserializeN_aryTree_428;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 428. Serialize and Deserialize N-ary Tree
 * https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/
 *
 * Serialization is the process of converting a data structure or object into
 * a sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in
 * the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize an N-ary tree. An N-ary
 * tree is a rooted tree in which each node has no more than N children. There
 * is no restriction on how your serialization/deserialization algorithm
 * should work. You just need to ensure that an N-ary tree can be serialized
 * to a string and this string can be deserialized to the original tree structure.
 *
 * For example, you may serialize the following 3-ary tree
 *                      1
 *                   /  |  \
 *                  3   2   4
 *                 /\
 *                5  6
 *
 * as [1 [3[5 6] 2 4]]. Note that this is just an example, you do not
 * necessarily need to follow this format.
 *
 * Or you can follow LeetCode's level order traversal serialization format,
 * where each group of children is separated by the null value.
 *
 *                      1
 *                 /  /   \  \
 *                2  3    4   5
 *                  /\    |   / \
 *                  6 7   8  9  10
 *                    |   |  |
 *                    11  12 13
 *                    |
 *                    14
 * For example, the above tree may be serialized as
 * [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14].
 *
 * You do not necessarily need to follow the above suggested formats, there
 * are many more different formats that work so please be creative and come
 * up with different approaches yourself.
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 104].
 * 0 <= Node.val <= 104
 * The height of the n-ary tree is less than or equal to 1000
 * Do not use class member/global/static variables to store states. Your encode
 * and decode algorithms should be stateless.
 */
public class Solution {
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        System.out.println(sb.toString());
        return sb.toString();
    }

    private void dfs(Node root, StringBuilder sb) {
        if (root == null) {
            sb.append("-,");
            return;
        }
        sb.append(root.val).append(",");
        if (root.children == null || root.children.isEmpty()) {
            sb.append("-,");
        } else {
            for (Node child : root.children) {
                dfs(child, sb);
            }
            sb.append("-,");
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data == null) return null;
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(nodes);
    }

    private Node deserialize(Queue<String> nodes) {
        String n = nodes.poll();
        if (n.equals("-")) return null;
        Node root = new Node(Integer.parseInt(n));
        root.children = new ArrayList<>();
        while (!nodes.isEmpty() && !nodes.peek().equals("-")) {
            root.children.add(deserialize(nodes));
        }
        if (nodes.peek().equals("-")) nodes.poll();
        return root;
    }
}
