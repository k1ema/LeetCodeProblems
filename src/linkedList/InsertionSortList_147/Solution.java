package linkedList.InsertionSortList_147;

import linkedList.utils.ListNode;

/**
 * 147. Insertion Sort List
 * https://leetcode.com/problems/insertion-sort-list/
 *
 * Sort a linked list using insertion sort.
 *
 * A graphical example of insertion sort. The partial sorted list (black) initially
 * contains only the first element in the list.
 * With each iteration one element (red) is removed from the input data and inserted
 * in-place into the sorted list
 *
 *
 * Algorithm of Insertion Sort:
 * Insertion sort iterates, consuming one input element each repetition, and growing
 * a sorted output list.
 * At each iteration, insertion sort removes one element from the input data, finds
 * the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
 *
 * Example 1:
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 *
 * Example 2:
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class Solution {
    // tc O(n^2), sc O(1)
    // 29 ms, faster than 53.37%; 38.9 MB, less than 6.84%
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy, cur = head, next;
        while (cur != null) {
            next = cur.next;
            while (prev.next != null && prev.next.val < cur.val) {
                prev = prev.next;
            }
            cur.next = prev.next;
            prev.next = cur;
            prev = dummy;
            cur = next;
        }
        return dummy.next;
    }
}
