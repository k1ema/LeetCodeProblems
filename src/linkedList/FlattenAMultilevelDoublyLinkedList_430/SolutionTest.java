package linkedList.FlattenAMultilevelDoublyLinkedList_430;

import linkedList.FlattenAMultilevelDoublyLinkedList_430.Solution.Node;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        Node head_1 = new Node(1);
        Node head_2 = new Node(2);
        Node head_3 = new Node(3);
        Node head_4 = new Node(4);
        Node head_5 = new Node(5);
        Node head_6 = new Node(6);
        Node head_7 = new Node(7);
        Node head_8 = new Node(8);
        Node head_9 = new Node(9);
        Node head_10 = new Node(10);
        Node head_11 = new Node(11);
        Node head_12 = new Node(12);

        head_1.next = head_2;
        head_2.prev = head_1;
        head_2.next = head_3;
        head_3.prev = head_2;
        head_3.next = head_4;
        head_4.prev = head_3;
        head_4.next = head_5;
        head_5.prev = head_4;
        head_5.next = head_6;
        head_6.prev = head_5;

        head_3.child = head_7;
        head_7.next = head_8;
        head_8.prev = head_7;
        head_8.next = head_9;
        head_9.prev = head_8;
        head_9.next = head_10;
        head_10.prev = head_9;

        head_8.child = head_11;
        head_11.next = head_12;
        head_12.prev = head_11;

        Node res_1 = new Node(1);
        Node res_2 = new Node(2);
        Node res_3 = new Node(3);
        Node res_4 = new Node(4);
        Node res_5 = new Node(5);
        Node res_6 = new Node(6);
        Node res_7 = new Node(7);
        Node res_8 = new Node(8);
        Node res_9 = new Node(9);
        Node res_10 = new Node(10);
        Node res_11 = new Node(11);
        Node res_12 = new Node(12);

        res_1.next = res_2;
        res_2.prev = res_1;
        res_2.next = res_3;
        res_3.prev = res_2;
        res_3.next = res_7;
        res_7.prev = res_3;
        res_7.next = res_8;
        res_8.prev = res_7;
        res_8.next = res_11;
        res_11.prev = res_8;
        res_11.next = res_12;
        res_12.prev = res_11;
        res_12.next = res_9;
        res_9.prev = res_12;
        res_9.next = res_10;
        res_10.prev = res_9;
        res_10.next = res_4;
        res_4.prev = res_10;
        res_4.next = res_5;
        res_5.prev = res_4;
        res_5.next = res_6;
        res_6.prev = res_5;

        assertEquals(res_1, s.flatten(head_1));
    }
}