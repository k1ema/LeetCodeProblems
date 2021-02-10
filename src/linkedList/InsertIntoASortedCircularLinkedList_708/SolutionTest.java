package linkedList.InsertIntoASortedCircularLinkedList_708;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        Solution.Node head = new Solution.Node(3);
        head.next = new Solution.Node(4);
        head.next.next = new Solution.Node(1);
        head.next.next.next = head;
        Solution.Node expected = new Solution.Node(3);
        expected.next = new Solution.Node(4);
        expected.next.next = new Solution.Node(1);
        expected.next.next.next = new Solution.Node(2);
        expected.next.next.next.next = expected;
        assertEquals(expected, s.insert(head, 2));

        head = new Solution.Node(3);
        head.next = new Solution.Node(3);
        head.next.next = new Solution.Node(5);
        head.next.next.next = head;
        expected = new Solution.Node(3);
        expected.next = new Solution.Node(3);
        expected.next.next = new Solution.Node(5);
        expected.next.next.next = new Solution.Node(0);
        expected.next.next.next.next = expected;
        assertEquals(expected, s.insert(head, 0));

        head = new Solution.Node(3);
        head.next = new Solution.Node(3);
        head.next.next = new Solution.Node(5);
        head.next.next.next = head;
        expected = new Solution.Node(3);
        expected.next = new Solution.Node(3);
        expected.next.next = new Solution.Node(5);
        expected.next.next.next = new Solution.Node(6);
        expected.next.next.next.next = expected;
        assertEquals(expected, s.insert(head, 6));

        head = new Solution.Node(3);
        head.next = new Solution.Node(3);
        head.next.next = new Solution.Node(3);
        head.next.next.next = head;
        expected = new Solution.Node(3);
        expected.next = new Solution.Node(0);
        expected.next.next = new Solution.Node(3);
        expected.next.next.next = new Solution.Node(3);
        expected.next.next.next.next = expected;
        assertEquals(expected, s.insert(head, 0));

        head = new Solution.Node(3);
        head.next = new Solution.Node(3);
        head.next.next = new Solution.Node(3);
        head.next.next.next = head;
        expected = new Solution.Node(3);
        expected.next = new Solution.Node(4);
        expected.next.next = new Solution.Node(3);
        expected.next.next.next = new Solution.Node(3);
        expected.next.next.next.next = expected;
        assertEquals(expected, s.insert(head, 4));

        head = new Solution.Node(3);
        head.next = new Solution.Node(3);
        head.next.next = new Solution.Node(3);
        head.next.next.next = head;
        expected = new Solution.Node(3);
        expected.next = new Solution.Node(3);
        expected.next.next = new Solution.Node(3);
        expected.next.next.next = new Solution.Node(3);
        expected.next.next.next.next = expected;
        assertEquals(expected, s.insert(head, 3));

        head = new Solution.Node(3);
        head.next = new Solution.Node(4);
        head.next.next = new Solution.Node(1);
        head.next.next.next = head;
        expected = new Solution.Node(3);
        expected.next = new Solution.Node(4);
        expected.next.next = new Solution.Node(10);
        expected.next.next.next = new Solution.Node(1);
        expected.next.next.next.next = expected;
        assertEquals(expected, s.insert(head, 10));

        head = new Solution.Node(3);
        head.next = new Solution.Node(4);
        head.next.next = new Solution.Node(1);
        head.next.next.next = head;
        expected = new Solution.Node(3);
        expected.next = new Solution.Node(4);
        expected.next.next = new Solution.Node(1);
        expected.next.next.next = new Solution.Node(2);
        expected.next.next.next.next = expected;
        assertEquals(expected, s.insert(head, 2));

        head = new Solution.Node(3);
        head.next = new Solution.Node(4);
        head.next.next = new Solution.Node(1);
        head.next.next.next = head;
        expected = new Solution.Node(3);
        expected.next = new Solution.Node(4);
        expected.next.next = new Solution.Node(-1);
        expected.next.next.next = new Solution.Node(1);
        expected.next.next.next.next = expected;
        assertEquals(expected, s.insert(head, -1));

        head = null;
        expected = new Solution.Node(1);
        expected.next = expected;
        assertEquals(expected, s.insert(head, 1));

        head = new Solution.Node(1);
        head.next = head;
        expected = new Solution.Node(1);
        expected.next = new Solution.Node(3);
        expected.next.next = expected;
        assertEquals(expected, s.insert(head, 3));

        head = new Solution.Node(3);
        head.next = head;
        expected = new Solution.Node(3);
        expected.next = new Solution.Node(3);
        expected.next.next = expected;
        assertEquals(expected, s.insert(head, 3));

        head = new Solution.Node(3);
        head.next = head;
        expected = new Solution.Node(3);
        expected.next = new Solution.Node(4);
        expected.next.next = expected;
        assertEquals(expected, s.insert(head, 4));
    }
}