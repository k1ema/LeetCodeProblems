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
    // tc O(m+n), sc O(m+n)
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int na = 0;
        ListNode tmpA = headA;
        while (tmpA != null) {
            tmpA = tmpA.next;
            na++;
        }
        int nb = 0;
        ListNode tmpB = headB;
        while (tmpB != null) {
            tmpB = tmpB.next;
            nb++;
        }
        ListNode tmp = null;
        if (na > nb) {
            tmp = headA;
        } else if (nb > na) {
            tmp = headB;
        }
        for (int i = 0; i < Math.abs(na - nb); i++) {
            tmp = tmp.next;
        }
        return goDeeper(na > nb ? tmp : headA, nb > na ? tmp : headB);
    }

    private ListNode goDeeper(ListNode headA, ListNode headB) {
        while (headA != null && !headA.equals(headB)) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
