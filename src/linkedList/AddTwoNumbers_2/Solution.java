package linkedList.AddTwoNumbers_2;

import linkedList.utils.ListNode;

/**
 * 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class Solution {
    // tc O(n), sc O(n)
    // 1 ms, faster than 100.00%; 39.7 MB, less than 99.69%
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        sum(result, l1, l2, 0);
        return result.next;
    }

    private void sum(ListNode result, ListNode l1, ListNode l2, int s) {
        if (l1 == null && l2 == null) {
            if (s > 0) {
                result.next = new ListNode(s);
            }
            return;
        }

        int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + s;
        result.next = new ListNode(sum % 10);
        sum(result.next, l1 != null ? l1.next : null, l2 != null ? l2.next : null, sum / 10);
    }
}
