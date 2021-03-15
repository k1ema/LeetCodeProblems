package linkedList.SwappingNodesInALinkedList_1721;

import linkedList.utils.ListNode;

/**
 * 1721. Swapping Nodes in a Linked List
 * https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 *
 * You are given the head of a linked list, and an integer k.
 *
 * Return the head of the linked list after swapping the values of the kth node from the
 * beginning and the kth node from the end (the list is 1-indexed).
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [1,4,3,2,5]
 *
 * Example 2:
 * Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * Output: [7,9,6,6,8,7,3,0,9,5]
 *
 * Example 3:
 * Input: head = [1], k = 1
 * Output: [1]
 *
 * Example 4:
 * Input: head = [1,2], k = 1
 * Output: [2,1]
 *
 * Example 5:
 * Input: head = [1,2,3], k = 2
 * Output: [1,2,3]
 *
 * Constraints:
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 10^5
 * 0 <= Node.val <= 100
 */
public class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        int n = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            n++;
        }

        int t1 = k, t2 = n - k + 1, i = 1;
        if (t1 == t2) return head;
        ListNode cur = head;
        ListNode target1 = null, target2 = null;
        while (cur != null) {
            if (i == t1) {
                target1 = cur;
            }
            if (i == t2) {
                target2 = cur;
            }
            if (target1 != null && target2 != null) {
                break;
            }
            i++;
            cur = cur.next;
        }

        if (target1 == null || target2 == null) {
            throw new IllegalArgumentException("k must be within 1.." + n);
        }
        int tmp = target1.val;
        target1.val = target2.val;
        target2.val = tmp;

        return head;
    }
}
