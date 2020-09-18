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
    // tc O(n), sc O(n)
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        return reverseList(null, head);
    }

    private ListNode reverseList(ListNode prev, ListNode cur) {
        ListNode head = cur;
        if (cur.next != null) {
            head = reverseList(cur, cur.next);
        }
        cur.next = prev;
        return head;
    }

    private ListNode reverseList1(ListNode prev, ListNode cur) {
        if (cur.next == null) {
            cur.next = prev;
            return cur;
        }
        ListNode head = reverseList(cur, cur.next);
        cur.next = prev;
        return head;
    }

    // tc O(n), sc O(1)
    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        // next ... curr.next ... curr.next ... prev
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
