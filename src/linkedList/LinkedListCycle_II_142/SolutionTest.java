package linkedList.LinkedListCycle_II_142;

import linkedList.utils.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = b;

        Solution s = new Solution();
        assertEquals(b, s.detectCycle(a));
    }
}