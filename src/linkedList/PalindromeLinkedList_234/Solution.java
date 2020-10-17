package linkedList.PalindromeLinkedList_234;

import linkedList.utils.ListNode;

/**
 * 234. Palindrome Linked List
 *
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 * Input: 1->2
 * Output: false
 *
 * Example 2:
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class Solution {
    // tc O(n), sc O(1)
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // find midlle
        ListNode slow = null, fast = head;
        ListNode l1 = head;
        boolean even = false;
        while (fast != null && fast.next != null) {
            slow = slow == null ? head : slow.next;
            fast = fast.next.next;
        }
        if (fast == null) even = true;
        ListNode l2 = slow.next;
        slow.next = null;

        // reverse l1: prev.next = null, cur.next = prev
        ListNode prev = null, cur = l1;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        l1 = prev;

        // compare l1 and l2
        if (!even) l2 = l2.next;
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }

        return l1 == null && l2 == null;
    }
}
