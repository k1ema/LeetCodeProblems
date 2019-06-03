package linkedList.IntersectionOfTwoLinkedLists_160;

import org.junit.Assert;
import org.junit.Test;

import linkedList.utils.ListNode;

import static linkedList.utils.Parser.stringToListNode;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        ListNode headA = stringToListNode("[4,1,8,4,5]");
        ListNode headB = stringToListNode("[5,0,1,8,4,5]");
        ListNode result = s.getIntersectionNode(headA, headB);
        System.out.println(result);
        Assert.assertEquals(stringToListNode("[1,8,4,5]"), result);

        result = s.getIntersectionNode(stringToListNode("[0,9,1,2,4]"), stringToListNode("[3,2,4]"));
        System.out.println(result);
        Assert.assertEquals(stringToListNode("[2,4]"), result);

        result = s.getIntersectionNode(stringToListNode("[2,6,4]"), stringToListNode("[1,5]"));
        System.out.println(result);
        Assert.assertNull(result);

        result = s.getIntersectionNode(stringToListNode("[2]"), stringToListNode("[1]"));
        System.out.println(result);
        Assert.assertNull(result);

        Assert.assertNull(s.getIntersectionNode(null, null));
    }
}
