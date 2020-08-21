package linkedList.ReorderList_143;

import linkedList.utils.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 143. Reorder List
 * https://leetcode.com/problems/reorder-list/
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example 1:
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 *
 * Example 2:
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class Solution {
    // tc O(n), sc O(1)
    // 4 ms, faster than 17.30%; 50.1 MB, less than 28.95%
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // 1. find the middle of ll
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. revert 2nd part
        ListNode cur = slow, prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        // 3. merge two parts
        ListNode first = head, second = prev; // 1-2-3-4; 4-3
        while (second.next != null) {
            ListNode tmp = first.next;
            first.next = second;
            first = tmp;

            tmp = second.next;
            second.next = first;
            second = tmp;
        }
    }

    // my solution
    // tc O(n), sc O(n)
    public void reorderList1(ListNode head) {
        ListNode list = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int j = 0;
        while (list != null) {
            map.put(j++, list);
            list = list.next;
        }

        int n = map.size() - 1;
        for (int i = 0; i <= n / 2; i++) {
            ListNode node = map.get(i);
            ListNode right = map.get(n - i);
            if (right == node) return;
            map.get(n - i - 1).next = null;
            node.next = right;
            right.next = map.get(i + 1);
            right.next.next = null;
        }
    }
}
