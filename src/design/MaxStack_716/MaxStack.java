package design.MaxStack_716;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 716. Max Stack
 * https://leetcode.com/problems/max-stack/
 *
 * Design a max stack data structure that supports the stack operations and supports finding the stack's maximum element.
 *
 * Implement the MaxStack class:
 *
 * MaxStack() Initializes the stack object.
 * void push(int x) Pushes element x onto the stack.
 * int pop() Removes the element on top of the stack and returns it.
 * int top() Gets the element on the top of the stack without removing it.
 * int peekMax() Retrieves the maximum element in the stack without removing it.
 * int popMax() Retrieves the maximum element in the stack and removes it. If there is more than one maximum element, only remove the top-most one.
 *
 * Example 1:
 * Input
 * ["MaxStack", "push", "push", "push", "top", "popMax", "top", "peekMax", "pop", "top"]
 * [[], [5], [1], [5], [], [], [], [], [], []]
 * Output
 * [null, null, null, null, 5, 5, 1, 5, 1, 5]
 *
 * Explanation
 * MaxStack stk = new MaxStack();
 * stk.push(5);   // [5] the top of the stack and the maximum number is 5.
 * stk.push(1);   // [5, 1] the top of the stack is 1, but the maximum is 5.
 * stk.push(5);   // [5, 1, 5] the top of the stack is 5, which is also the maximum, because it is the top most one.
 * stk.top();     // return 5, [5, 1, 5] the stack did not change.
 * stk.popMax();  // return 5, [5, 1] the stack is changed now, and the top is different from the max.
 * stk.top();     // return 1, [5, 1] the stack did not change.
 * stk.peekMax(); // return 5, [5, 1] the stack did not change.
 * stk.pop();     // return 1, [5] the top of the stack and the max element is now 5.
 * stk.top();     // return 5, [5] the stack did not change.
 *
 * Constraints:
 * -10^7 <= x <= 10^7
 * At most 10^4 calls will be made to push, pop, top, peekMax, and popMax.
 * There will be at least one element in the stack when pop, top, peekMax, or popMax is called.
 *
 * Follow up: Could you come up with a solution that supports O(1) for each top call and O(logn) for each other call?
 */
public class MaxStack {
    private static class Node {
        private int val;
        private Node prev, next;
        Node(int val) {
            this.val = val;
        }
        @Override
        public String toString() {
            return String.format("%d->%s", val, next);
        }
    }

    private Node head;
    private TreeMap<Integer, List<Node>> maxMap;

    /** initialize your data structure here. */
    public MaxStack() {
        head = new Node((int) -1e8);
        maxMap = new TreeMap<>((a, b) -> b - a);
    }

    // tc O(logn)
    public void push(int x) {
        Node newHead = new Node(x);
        Node next = head.next;
        head.next = newHead;
        newHead.prev = head;
        newHead.next = next;
        if (next != null) {
            next.prev = newHead;
        }
        maxMap.putIfAbsent(x, new ArrayList<>());
        maxMap.get(x).add(newHead);
    }

    // tc O(logn)
    public int pop() {
        Node toRemove = head.next;
        List<Node> nodes = maxMap.get(toRemove.val);
        nodes.remove(nodes.size() - 1);
        if (nodes.isEmpty()) {
            maxMap.remove(toRemove.val);
        }
        Node next = toRemove.next;
        head.next = next;
        if (next != null) {
            next.prev = head;
        }
        return toRemove.val;
    }

    // tc O(1)
    public int top() {
        return head.next.val;
    }

    // tc O(1)
    public int peekMax() {
        return maxMap.firstKey();
    }

    // tc O(logn)
    public int popMax() {
        Map.Entry<Integer, List<Node>> entry = maxMap.pollFirstEntry();
        Node max = entry.getValue().remove(entry.getValue().size() - 1);
        if (entry.getValue().isEmpty()) {
            maxMap.remove(entry.getKey());
        } else {
            maxMap.put(entry.getKey(), entry.getValue());
        }
        Node prev = max.prev;
        Node next = max.next;
        prev.next = next;
        if (next != null) {
            next.prev = prev;
        }
        return max.val;
    }
}
