package linkedList.RemoveNthNodeFromEndOfList_19;

import linkedList.utils.ListNode;

/**
 * 19. Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * Note:
 * Given n will always be valid.
 *
 * Follow up:
 * Could you do this in one pass?
 */
public class Solution {
    // tc O(n), sc O(1), 0ms
    ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        int nn = n;
        while (nn > 0) {
            second = second.next;
            nn--;
        }
        while (second.next != null) {
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    // my solution, 0ms
    // tc O(n), sc O(1?) (it seems should be O(n) i.e we allocate {int nn} in recursion) but memory usage 100%
    ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        traverse(dummy, n);
        return dummy.next;
    }

    private int traverse(ListNode curr, int n) {
        if (curr == null) {
            return n;
        }

        int nn = traverse(curr.next, n);
        if (nn == 0 && curr.next != null) {
            curr.next = curr.next.next;
        }
        return nn - 1;
    }
}
