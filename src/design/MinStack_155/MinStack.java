package design.MinStack_155;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 155. Min Stack
 * https://leetcode.com/problems/min-stack/
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
public class MinStack {
    private Deque<Integer> stack;
    private Integer min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayDeque<>();
        min = null;
    }

    public void push(int val) {
        if (min == null) {
            min = val;
        }
        if (val <= min) {
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }

    public void pop() {
        if (stack.pop().equals(min)) {
            min = stack.pop();
        }
        if (stack.isEmpty()) {
            min = null;
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if (min == null) throw new NullPointerException();
        return min;
    }
}
