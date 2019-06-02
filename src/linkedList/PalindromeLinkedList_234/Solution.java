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
    boolean isPalindrome(ListNode head) {
        // check
        if (head == null || head.next == null) {
            return true;
        }
        if (head.next.next == null) {
            return head.val == head.next.val;
        }

        // 1. move to center
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }

        // 2. reverse 2nd part
        ListNode reversed = reverse(slow);

        // 3. compare reversed and 1st part
        while (reversed != null) {
            if (reversed.val != head.val) {
                return false;
            }
            reversed = reversed.next;
            head = head.next;
        }

        return true;
    }

    private ListNode reverse(ListNode list) {
        if (list.next == null) {
            return list;
        }
        ListNode cur = reverse(list.next);
        list.next.next = list;
        list.next = null;
        return cur;
    }
}
