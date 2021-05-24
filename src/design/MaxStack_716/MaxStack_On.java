package design.MaxStack_716;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * tc O(n)
 */
public class MaxStack_On {
    Deque<Integer> stack;
    Deque<Integer> maxStack;

    public MaxStack_On() {
        stack = new ArrayDeque<>();
        maxStack = new ArrayDeque();
    }

    public void push(int x) {
        int max = maxStack.isEmpty() ? x : maxStack.peek();
        maxStack.push(max > x ? max : x);
        stack.push(x);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = peekMax();
        Deque<Integer> buffer = new ArrayDeque<>();
        while (top() != max) buffer.push(pop());
        pop();
        while (!buffer.isEmpty()) push(buffer.pop());
        return max;
    }
}
