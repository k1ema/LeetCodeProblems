package linkedList.InsertIntoASortedCircularLinkedList_708;

import java.util.Objects;

/**
 * 708. Insert into a Sorted Circular Linked List
 * https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/
 *
 * Given a node from a Circular Linked List which is sorted in ascending order,
 * write a function to insert a value insertVal into the list such that it remains
 * a sorted circular list. The given node can be a reference to any single node in
 * the list, and may not be necessarily the smallest value in the circular list.
 *
 * If there are multiple suitable places for insertion, you may choose any place
 * to insert the new value. After the insertion, the circular list should remain
 * sorted.
 *
 * If the list is empty (i.e., given node is null), you should create a new single
 * circular list and return the reference to that single node. Otherwise, you
 * should return the original given node.
 *
 * Example 1:
 * Input: head = [3,4,1], insertVal = 2
 * Output: [3,4,1,2]
 * Explanation: In the figure above, there is a sorted circular list of three
 * elements. You are given a reference to the node with value 3, and we need to
 * insert 2 into the list. The new node should be inserted between node 1 and
 * node 3. After the insertion, the list should look like this, and we should
 * still return node 3.
 *
 * Example 2:
 * Input: head = [], insertVal = 1
 * Output: [1]
 * Explanation: The list is empty (given head is null). We create a new single
 * circular list and return the reference to that single node.
 *
 * Example 3:
 * Input: head = [1], insertVal = 0
 * Output: [1,0]
 *
 * Constraints:
 * 0 <= Number of Nodes <= 5 * 10^4
 * -10^6 <= Node.val <= 10^6
 * -10^6 <= insertVal <= 10^6
 */
public class Solution {
    // tc O(n), sc O(1)
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        Node cur = head;
        boolean inserted = false;
        while (true) {
            if (insertVal >= cur.val && insertVal <= cur.next.val
                    || cur.val > cur.next.val && (insertVal >= cur.val || insertVal <= cur.next.val)) {
                Node next = cur.next;
                cur.next = new Node(insertVal);
                cur.next.next = next;
                inserted = true;
                break;
            }
            cur = cur.next;
            if (cur.equals(head)) break;
        }
        // only if all values in Node are the same
        if (!inserted) {
            Node next = head.next;
            head.next = new Node(insertVal);
            head.next.next = next;
        }
        return head;
    }

    // my solution
    // tc O(n), sc O(1)
    public Node insert1(Node head, int insertVal) {
        if (head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        Node cur = head;
        while (true) {
            if (insertVal >= cur.val && insertVal <= cur.next.val
                    || (cur.val > cur.next.val || cur.equals(cur.next)) && (insertVal >= cur.val || insertVal <= cur.next.val)
                    || checkAllEquals(cur)) {
                Node next = cur.next;
                cur.next = new Node(insertVal);
                cur.next.next = next;
                break;
            }
            cur = cur.next;
        }
        return head;
    }

    private boolean checkAllEquals(Node cur) {
        Node slow = cur, fast = cur.next;
        int prevSlow = slow.val, prevFast = fast.val;
        while (!slow.equals(fast)) {
            slow = slow.next;
            fast = fast.next.next;
            if (prevSlow != slow.val || prevFast != fast.val) {
                return false;
            }
            prevSlow = slow.val; prevFast = fast.val;
        }
        return true;
    }

    static class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return val == node.val && next.val == node.next.val
                    && next.next.val == node.next.next.val
                    && next.next.next.val == node.next.next.next.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next.val, next.next.val, next.next.next.val, next.next.next.next.val);
        }

        @Override
        public String toString() {
            return String.format("%d->%d->%d->%d", val, next.val, next.next.val, next.next.next.val);
        }
    }
}
