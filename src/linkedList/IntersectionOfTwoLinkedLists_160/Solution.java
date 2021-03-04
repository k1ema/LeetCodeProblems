package linkedList.IntersectionOfTwoLinkedLists_160;

import linkedList.utils.ListNode;

/**
 * 160. Intersection of Two Linked Lists
 *
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * Example: [a1,a2,c1,c2,c3] and [b1,b2,b3,c1,c2,c3] begin to intersect at node c1.
 * Output: Reference of the node with value = c1.
 *
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class Solution {
    // tc O(max(m,n)), sc O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lenA = calcLen(headA);
        int lenB = calcLen(headB);

        ListNode a = headA, b = headB;
        while (lenA > lenB) {
            a = a.next;
            lenA--;
        }
        while (lenB > lenA) {
            b = b.next;
            lenB--;
        }
        while (a != null) {
            if (a.equals(b)) {
                return a;
            }
            a = a.next;
            b = b.next;
        }
        return null;
    }

    private int calcLen(ListNode list) {
        int len = 0;
        ListNode tmp = list;
        while (tmp != null) {
            tmp = tmp.next;
            len++;
        }
        return len;
    }
}
