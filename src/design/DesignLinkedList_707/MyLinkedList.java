package design.DesignLinkedList_707;

/**
 * 707. Design Linked List
 * https://leetcode.com/problems/design-linked-list/
 *
 * Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
 * A node in a singly linked list should have two attributes: val and next. val is the value of the current
 * node, and next is a pointer/reference to the next node.
 * If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous
 * node in the linked list. Assume all nodes in the linked list are 0-indexed.
 *
 * Implement the MyLinkedList class:
 *
 * MyLinkedList() Initializes the MyLinkedList object.
 * int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
 * void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion,
 * the new node will be the first node of the linked list.
 * void addAtTail(int val) Append a node of value val as the last element of the linked list.
 * void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index
 * equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater
 * than the length, the node will not be inserted.
 * void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 *
 * Example 1:
 * Input
 * ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
 * [[], [1], [3], [1, 2], [1], [1], [1]]
 * Output
 * [null, null, null, null, 2, null, 3]
 *
 * Explanation
 * MyLinkedList myLinkedList = new MyLinkedList();
 * myLinkedList.addAtHead(1);
 * myLinkedList.addAtTail(3);
 * myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
 * myLinkedList.get(1);              // return 2
 * myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
 * myLinkedList.get(1);              // return 3
 *
 *
 * Constraints:
 * 0 <= index, val <= 1000
 * Please do not use the built-in LinkedList library.
 * At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and deleteAtIndex.
 */
public class MyLinkedList {
    private static class ListNode {
        private int val;
        private ListNode next;
        private ListNode prev;

        ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode head, tail;
    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next = tail;
        tail.prev = head;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        ListNode target = head.next;
        while (index-- > 0 && target.val != -1) {
            target = target.next;
        }
        return target.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val);
        ListNode oldHead = head.next;
        head.next = newHead;
        newHead.prev = head;
        newHead.next = oldHead;
        oldHead.prev = newHead;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode oldTail = tail.prev;
        ListNode newTail = new ListNode(val);
        tail.prev = newTail;
        newTail.next = tail;
        newTail.prev = oldTail;
        oldTail.next = newTail;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        if (index == size) {
            addAtTail(val);
        } else {
            ListNode target = head.next;
            while (index-- > 0) {
                target = target.next;
            }
            ListNode newNode = new ListNode(val);
            ListNode prev = target.prev;
            prev.next = newNode;
            newNode.prev = prev;
            newNode.next = target;
            target.prev = newNode;
            size++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        ListNode target = head.next;
        while (index-- > 0) {
            target = target.next;
        }
        ListNode next = target.next;
        ListNode prev = target.prev;
        prev.next = next;
        next.prev = prev;
        size--;
    }
}
