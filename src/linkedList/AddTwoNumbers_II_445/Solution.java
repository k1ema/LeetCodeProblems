package linkedList.AddTwoNumbers_II_445;

import linkedList.utils.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 445. Add Two Numbers II
 * https://leetcode.com/problems/add-two-numbers-ii/
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 *
 * Example:
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */
public class Solution {
    // without reversing list, use stacks
    // 4 ms, faster than 29.01%; 45.5 MB, less than 9.37%
    // tc O(max(l1, l2)), sc O(max(l1, l2))
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        while (l1 != null) {
            stack1.addFirst(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.addFirst(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int v = (stack1.isEmpty() ? 0 : stack1.pollFirst()) + (stack2.isEmpty() ? 0 : stack2.pollFirst()) + carry;
            carry = v / 10;
            ListNode cur = new ListNode(v % 10);
            cur.next = head;
            head = cur;
        }
        if (carry > 0) {
            ListNode cur = new ListNode(carry);
            cur.next = head;
            head = cur;
        }
        return head;
    }

    // tc O(max(l1, l2)), sc O(max(l1, l2))
    // 2 ms	39.3 MB
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode r1 = reverse(l1);
        ListNode r2 = reverse(l2);
        ListNode head = null;
        int carry = 0;
        while (r1 != null || r2 != null) {
            int v = (r1 != null ? r1.val : 0) + (r2 != null ? r2.val : 0) + carry;
            carry = v / 10;
            ListNode cur = new ListNode(v % 10);
            cur.next = head;
            head = cur;
            if (r1 != null) r1 = r1.next;
            if (r2 != null) r2 = r2.next;
        }
        if (carry > 0) {
            ListNode cur = new ListNode(carry);
            cur.next = head;
            head = cur;
        }
        return head;
    }

    private ListNode reverse(ListNode list) {
        ListNode prev = null, cur = list;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
