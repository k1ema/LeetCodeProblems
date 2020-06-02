package linkedList.SortList_148;

import linkedList.utils.ListNode;

/**
 * 148. Sort List
 * https://leetcode.com/problems/sort-list/
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 *
 * Example 2:
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 *
 */
class Solution {
    // tc O(nlogn), sc O(1); bottom-to-up solution
    // 5 ms, faster than 30.xx%; 39.3 MB, less than 100.00%
    // https://leetcode.com/problems/sort-list/discuss/46712/Bottom-to-up(not-recurring)-with-o(1)-space-complextity-and-o(nlgn)-time-complextity
    ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int n = 0;
        while (head != null) {
            head = head.next;
            n++;
        }

        for (int step = 1; step < n; step <<= 1) {
            ListNode prev = dummy;
            ListNode cur = dummy.next;

            while (cur != null) {
                ListNode left = cur;
                ListNode right = split(left, step);
                cur = split(right, step);
                prev = merge(left, right, prev);
            }
        }

        return dummy.next;
    }

    private ListNode split(ListNode head, int step) {
        if (head == null) {
            return null;
        }
        for (int i = 1; i < step && head.next != null; i++) {
            head = head.next;
        }
        ListNode right = head.next;
        head.next = null;
        return right;
    }

    private ListNode merge(ListNode left, ListNode right, ListNode prev) {
        while (left != null && right != null) {
            if (left.val < right.val) {
                prev.next = left;
                left = left.next;
            } else {
                prev.next = right;
                right = right.next;
            }
            prev = prev.next;
        }
        if (left != null) {
            prev.next = left;
        } else if (right != null) {
            prev.next = right;
        }
        while (prev.next != null) {
            prev = prev.next;
        }

        return prev;
    }

    // recursive up-to-bottom solution; 3 ms, faster than 97.59%; 39.8 MB, less than 100.00%
    // https://leetcode.com/problems/sort-list/discuss/46714/Java-merge-sort-solution
    // tc O(nlogn), sc O(logn)
    ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(dummy.next);
        merge(left, right, dummy);

        return dummy.next;
    }
}
