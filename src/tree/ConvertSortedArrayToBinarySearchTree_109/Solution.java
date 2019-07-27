package tree.ConvertSortedArrayToBinarySearchTree_109;

import linkedList.utils.ListNode;
import tree.utils.TreeNode;

/**
 * 109. Convert Sorted Array to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 *
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary
 * tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted linked list: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class Solution {
    // tc O(nlogn), sc O(logn)
    TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = slow;
        ListNode tmp = prev;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode tree = new TreeNode(slow.val);
        tree.right = sortedListToBST(slow.next);
        prev.next = null;
        tree.left = sortedListToBST(tmp);

        return tree;
    }

    // Approach 3: Inorder Simulation
    // https://leetcode.com/articles/convert-sorted-list-to-binary-search-tree/
    // tc O(n), sc O(logn)
    private ListNode head;

    private int findSize(ListNode head) {
        ListNode ptr = head;
        int c = 0;
        while (ptr != null) {
            ptr = ptr.next;
            c += 1;
        }
        return c;
    }

    private TreeNode convertListToBST(int l, int r) {
        // Invalid case
        if (l > r) {
            return null;
        }

        int mid = (l + r) / 2;

        // First step of simulated inorder traversal. Recursively form the left half
        TreeNode left = convertListToBST(l, mid - 1);

        // Once left half is traversed, process the current node
        TreeNode node = new TreeNode(head.val);
        node.left = left;

        // Maintain the invariance mentioned in the algorithm
        head = head.next;

        // Recurse on the right hand side and form BST out of them
        node.right = convertListToBST(mid + 1, r);
        return node;
    }

    TreeNode sortedListToBST1(ListNode head) {
        // Get the size of the linked list first
        int size = this.findSize(head);

        this.head = head;

        // Form the BST now that we know the size
        return convertListToBST(0, size - 1);
    }

    // https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/discuss/35476/Share-my-JAVA-solution-1ms-very-short-and-concise.
    // tc O(nlogn), sc O(logn)
    TreeNode sortedListToBST2(ListNode head) {
        if (head == null) {
            return null;
        }
        return toBST(head, null);
    }

    private TreeNode toBST(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode tree = new TreeNode(slow.val);
        tree.left = toBST(head, slow);
        tree.right = toBST(slow.next, tail);
        return tree;
    }
}
