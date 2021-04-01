package linkedList.PalindromeLinkedList_234;

import linkedList.utils.ListNode;

/**
 * 234. Palindrome Linked List
 * https://leetcode.com/problems/palindrome-linked-list/
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
 *
 * Constraints:
 * The number of nodes in the list is in the range [1, 105].
 * 0 <= Node.val <= 9
 *
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class Solution {
    // tc O(n), sc O(1)
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // find middle node
        ListNode slow = head, fast = head;
        int n = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            n++;
        }

        // reverse right half
        ListNode prev = null, cur = slow;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        // compare two parts
        ListNode left = head, right = prev;
        while (n-- > 0) {
            if (left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }
}
