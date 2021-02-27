package tree.ConvertBinarySearchTreeToSortedDoublyLinkedList_426;

/**
 * 426. Convert Binary Search Tree to Sorted Doubly Linked List
 * https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 *
 * Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.
 *
 * You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a
 * doubly-linked list. For a circular doubly linked list, the predecessor of the first element is the last
 * element, and the successor of the last element is the first element.
 *
 * We want to do the transformation in place. After the transformation, the left pointer of the tree node
 * should point to its predecessor, and the right pointer should point to its successor. You should return
 * the pointer to the smallest element of the linked list.
 *
 * Example 1:
 * Input: root = [4,2,5,1,3]
 * Output: [1,2,3,4,5]
 * Explanation: The figure below shows the transformed BST. The solid line indicates the successor relationship,
 * while the dashed line means the predecessor relationship.
 *
 * Example 2:
 * Input: root = [2,1,3]
 * Output: [1,2,3]
 *
 * Example 3:
 * Input: root = []
 * Output: []
 * Explanation: Input is an empty tree. Output is also an empty Linked List.
 *
 * Example 4:
 * Input: root = [1]
 * Output: [1]
 *
 * Constraints:
 * -1000 <= Node.val <= 1000
 * Node.left.val < Node.val < Node.right.val
 * All values of Node.val are unique.
 * 0 <= Number of Nodes <= 2000
 */
public class Solution {
    // tc O(n), sc O(n)
    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        Node[] nodes = dfs(root);
        nodes[0].left = nodes[1];
        nodes[1].right = nodes[0];
        return nodes[0];
    }

    private Node[] dfs(Node node) {
        if (node == null) return null;

        Node[] fromLeft = dfs(node.left);
        if (fromLeft != null) {
            fromLeft[1].right = node;
            node.left = fromLeft[1];
        }

        Node[] fromRight = dfs(node.right);
        if (fromRight != null) {
            node.right = fromRight[0];
            fromRight[0].left = node;
        }

        Node leftMost = fromLeft != null ? fromLeft[0] : node;
        Node rightMost = fromRight != null ? fromRight[1] : node;
        return new Node[] {leftMost, rightMost};
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
