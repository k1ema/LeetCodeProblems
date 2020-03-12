package linkedList.LinkedListCycle_II_142;

import linkedList.utils.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. Linked List Cycle II
 * https://leetcode.com/problems/linked-list-cycle-ii/
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle,
 * return null.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents
 * the position (0-indexed) in the linked list where tail connects to. If pos is -1, then
 * there is no cycle in the linked list.
 *
 * Note: Do not modify the linked list.
 *
 * Example 1:
 * 3 -> 2 -> 0 -> -4
 *      ^          |
 *       ----------
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 * Example 2:
 * 1 -> 2
 * ^    |
 *  ----
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 * Example 3:
 * 1
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 *
 * Follow-up:
 * Can you solve it without using extra space?
 */
public class Solution {
    // tc O(n), sc O(1)
    // 0 ms, faster than 100.00%; 41.3 MB, less than 6.32%
    // https://www.geeksforgeeks.org/find-first-node-of-loop-in-a-linked-list/
    // https://leetcode.com/articles/linked-list-cycle-ii/ see Approach 2: Floyd's Tortoise and Hare
    ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                slow = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }

        return null;
    }

    // tc O(n), sc O(n)
    // 4 ms, faster than 18.61%; 41.7 MB, less than 6.32%
    ListNode detectCycle1(ListNode head) {
        Set<ListNode> visited = new HashSet<>();

        ListNode node = head;
        while (node != null) {
            if (visited.contains(node)) {
                return node;
            }
            visited.add(node);
            node = node.next;
        }

        return null;
    }
}
