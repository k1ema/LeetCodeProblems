package linkedList.CopyListWithRandomPointer_138;

import org.junit.jupiter.api.Test;

import static linkedList.CopyListWithRandomPointer_138.Solution.Node;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.random = head;
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.random = head.next.next;
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.random = head;
        head.next.next.random = head.next.next.next.next;
        assertEquals(head, s.copyRandomList(head));

//        head = new Node(1);
//        head.next = new Node(2);
//        head.random = head.next;
//        head.next.random = head.next;
//        assertEquals(head, s.copyRandomList(head));

        head = new Node(3);
        head.next = new Node(3);
        head.next.next = new Node(3);
        head.next.random = head;
        assertEquals(head, s.copyRandomList(head));
    }
}