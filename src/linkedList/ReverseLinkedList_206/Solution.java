package linkedList.ReverseLinkedList_206;

import linkedList.utils.ListNode;

/**
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * Reverse a singly linked list.
 *
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class Solution {
    // from leetcode recursive solution
    // tc O(n), sc O(n)
    ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    // iterate, time complexity O(n), space O(1)
    ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

    // recursive, time complexity: O(n), space: O(n)
    private ListNode result;
    ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        reverse(head);
        return result;
    }

    private ListNode reverse(ListNode head) {
        if (head.next != null) {
            ListNode next = reverse(head.next);
            next.next = new ListNode(head.val);
            return next.next;
        } else {
            result = head;
        }
        return result;
    }
}
