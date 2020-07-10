package linkedList.FlattenAMultilevelDoublyLinkedList_430;

import java.util.Objects;

/**
 * 430. Flatten a Multilevel Doubly Linked List
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 *
 * You are given a doubly linked list which in addition to the next and previous pointers, it could have a child
 * pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more
 * children of their own, and so on, to produce a multilevel data structure, as shown in the example below.
 *
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head
 * of the first level of the list.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * Output: [1,2,3,7,8,11,12,9,10,4,5,6]
 *
 * Explanation:
 * The multilevel linked list in the input is as follows:
 * After flattening the multilevel linked list it becomes:
 *
 * Example 2:
 * Input: head = [1,2,null,3]
 * Output: [1,3,2]
 *
 * Explanation:
 * The input multilevel linked list is as follows:
 *
 *   1---2---NULL
 *   |
 *   3---NULL
 *
 * Example 3:
 * Input: head = []
 * Output: []
 *
 * How multilevel linked list is represented in test case:
 *
 * We use the multilevel linked list from Example 1 above:
 *
 *  1---2---3---4---5---6--NULL
 *          |
 *          7---8---9---10--NULL
 *              |
 *              11--12--NULL
 * The serialization of each level is as follows:
 *
 * [1,2,3,4,5,6,null]
 * [7,8,9,10,null]
 * [11,12,null]
 * To serialize all levels together we will add nulls in each level to signify no node connects to the upper node of the previous level. The serialization becomes:
 *
 * [1,2,3,4,5,6,null]
 * [null,null,7,8,9,10,null]
 * [null,11,12,null]
 * Merging the serialization of each level and removing trailing nulls we obtain:
 *
 * [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 *
 * Constraints:
 * Number of Nodes will not exceed 1000.
 * 1 <= Node.val <= 10^5
 */
public class Solution {
    // 0 ms, faster than 100.00%; 39.5 MB, less than 10.08%
    // tc O(n), sc O(n) because of recursion stack
    public Node flatten(Node head) {
        if (head == null) return null;
        dfs(head);
        return head;
    }

    private Node dfs(Node head) {
        if (head.child == null) {
            return head.next != null ? dfs(head.next) : head;
        } else {
            Node next = head.next;
            Node childTail = dfs(head.child);
            head.next = head.child;
            head.child.prev = head;
            childTail.next = next;
            head.child = null;
            if (next != null) {
                next.prev = childTail;
                return dfs(next);
            } else {
                return childTail;
            }
        }
    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        Node(int val) {
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return val == node.val &&
                    (prev == null && node.prev == null || prev != null && node.prev != null && prev.val == node.prev.val) &&
                    (next == null && node.next == null || next != null && node.next != null && next.val == node.next.val) &&
                    (child == null && node.child == null || child != null && node.child != null && child.val == node.child.val);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, prev, next, child);
        }

        @Override
        public String toString() {
            return "" + val;
        }
    }
}
