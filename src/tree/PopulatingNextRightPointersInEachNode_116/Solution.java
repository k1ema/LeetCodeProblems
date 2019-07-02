package tree.PopulatingNextRightPointersInEachNode_116;

import java.util.Stack;

/**
 * 116. Populating Next Right Pointers in Each Node
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 *
 * You are given a perfect binary tree where all leaves are on the same level,
 * and every parent has two children. The binary tree has the following definition:
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next
 * right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * Example:
 *       1               1 -> null
 *     /  \            /   \
 *    2    3          2  -> 3 -> null
 *   / \  / \        / \   / \
 *  4  5 6  7       4->5->6->7 -> null
 * Explanation: Given the above perfect binary tree (Figure A), your function should
 * populate each next pointer to point to its next right node, just like in Figure B.
 *
 * Note:
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 */
public class Solution {
    private Stack<Node> stack = new Stack<>();

    // tc O(n), sc O(logn) - is not eligible because I used stack
    Node connect1(Node root) {
        if (root == null) return null;

        if (!stack.isEmpty()) {
            stack.pop().next = root.left;
        }

        root.left = connect(root.left);
        root.right = connect(root.right);

        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null) {
            stack.push(root.right);
        }

        return root;
    }

    // https://leetcode.com/problems/populating-next-right-pointers-in-each-node/discuss/37473/My-recursive-solution(Java)
    // tc O(n), sc O(1)
    Node connect(Node root) {
        dfs(root);
        return root;
    }

    void dfs(Node root) {
        if (root == null) return;

        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }

        dfs(root.left);
        dfs(root.right);
    }
}
