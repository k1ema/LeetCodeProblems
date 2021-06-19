package design.DesignLinkedList_707;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyLinkedListTest {
    @Test
    public void test() {
        MyLinkedList ll = new MyLinkedList();
        ll.addAtHead(1);
        ll.addAtTail(3);
        ll.addAtIndex(1, 2);
        assertEquals(2, ll.get(1));
        ll.deleteAtIndex(1);
        assertEquals(3, ll.get(1));

        ll = new MyLinkedList();
        ll.addAtHead(9);
        assertEquals(-1, ll.get(1));
        ll.addAtIndex(1, 1);
        ll.addAtIndex(1, 7);
        ll.deleteAtIndex(1);
        ll.addAtHead(7);
        ll.addAtHead(4);
        ll.deleteAtIndex(1);
        ll.addAtIndex(1, 4);
        ll.addAtHead(2);
        ll.deleteAtIndex(5);
    }
}