package linkedList.RemoveDuplicatesFromSortedList_II_82;

import linkedList.utils.ListNode;

/**
 * 82. Remove Duplicates from Sorted List II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 *
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct
 * numbers from the original list. Return the linked list sorted as well.
 *
 * Example 1:
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 *
 * Example 2:
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 *
 * Constraints:
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (prev.next.equals(cur)) {
                prev = prev.next;
            } else {
                prev.next = cur.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    // my solution
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, cur = head;
        boolean skip = false;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                    skip = true;
                }
                prev.next = cur.next;
            } else {
                prev.next = cur;
                prev = prev.next;
            }
            cur = cur.next;
            if (cur != null) {
                skip = false;
            }
        }
        if (skip) prev.next = null;
        return dummy.next;
    }
}
