package linkedList.MiddleOfTheLinkedList_876;

import java.util.ArrayList;
import java.util.List;

/**
 * 876. Middle of the Linked List
 * https://leetcode.com/problems/middle-of-the-linked-list/
 *
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * If there are two middle nodes, return the second middle node.
 *
 * Example 1:
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 *
 * Example 2:
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 *
 * Note:
 * The number of nodes in the given list will be between 1 and 100.
 */
class Solution {
    List<ListNode> l = new ArrayList<>();

    // time complexity O(n), space complexity O(n)
    ListNode middleNode(ListNode head) {
        l.clear();
        fillList(head);
        return l.get(l.size() / 2);
    }

    private void fillList(ListNode node) {
        if (node == null) {
            return;
        }
        l.add(node);
        fillList(node.next);
    }

    // time complexity O(n), space complexity O(1)
    ListNode middleNode1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
