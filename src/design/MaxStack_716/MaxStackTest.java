package design.MaxStack_716;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxStackTest {
    @Test
    public void test() {
        MaxStack s = new MaxStack();
        s.push(5);
        s.push(1);
        s.push(5);
        assertEquals(5, s.top());
        assertEquals(5, s.popMax());
        assertEquals(1, s.top());
        assertEquals(5, s.peekMax());
        assertEquals(1, s.pop());
        assertEquals(5, s.top());

        s = new MaxStack();
        s.push(5);
        s.push(1);
        s.push(3);
        assertEquals(5, s.popMax());
        assertEquals(3, s.popMax());
        assertEquals(1, s.popMax());

        s = new MaxStack();
        s.push(-2);
        assertEquals(-2, s.popMax());
        s.push(-45);
        s.push(-82);
        s.push(29);
        assertEquals(29, s.pop());
        assertEquals(-45, s.peekMax());
        s.push(40);
        assertEquals(40, s.pop());
        assertEquals(-82, s.pop());
        s.push(66);
        assertEquals(66, s.peekMax());
        assertEquals(66, s.peekMax());
        s.push(-61);
        assertEquals(66, s.peekMax());
        s.push(98);
        assertEquals(98, s.peekMax());
    }
}
