package linkedList.IntersectionOfTwoLinkedLists_160;

import linkedList.utils.ListNode;
import org.junit.jupiter.api.Test;

import static linkedList.utils.Parser.stringToListNode;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        ListNode headA = stringToListNode("[4,1,8,4,5]");
        ListNode headB = stringToListNode("[5,0,1,8,4,5]");
        ListNode result = s.getIntersectionNode(headA, headB);
        System.out.println(result);
        assertEquals(stringToListNode("[1,8,4,5]"), result);

        result = s.getIntersectionNode(stringToListNode("[0,9,1,2,4]"), stringToListNode("[3,2,4]"));
        System.out.println(result);
        assertEquals(stringToListNode("[2,4]"), result);

        result = s.getIntersectionNode(stringToListNode("[2,6,4]"), stringToListNode("[1,5]"));
        System.out.println(result);
        assertNull(result);

        result = s.getIntersectionNode(stringToListNode("[2]"), stringToListNode("[1]"));
        System.out.println(result);
        assertNull(result);

        assertNull(s.getIntersectionNode(null, null));
    }
}
