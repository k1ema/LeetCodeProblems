package linkedList.RemoveLinkedListElements_203;

import linkedList.utils.ListNode;

/**
 * 203. Remove Linked List Elements
 * https://leetcode.com/problems/remove-linked-list-elements/
 *
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
public class Solution {
    // tc O(n), sc O(1)
    // 0 ms, faster than 100%; 40.2 MB, less than 75.57%
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
            } else {
                prev = head;
            }
            head = head.next;
        }
        return dummy.next;
    }

    // recursive
    // 2 ms, faster than 12.45%, 46.9 MB, less than 5.11%
    public ListNode removeElements1(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        bt(dummy, head, val);
        return dummy.next;
    }

    private ListNode bt(ListNode prev, ListNode cur, int val) {
        if (cur == null) return null;
        if (cur.val == val) {
            prev.next = cur.next;
        } else {
            prev = cur;
        }
        return bt(prev, cur.next, val);
    }
}
