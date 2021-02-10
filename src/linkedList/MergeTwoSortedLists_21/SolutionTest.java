package linkedList.MergeTwoSortedLists_21;

import linkedList.utils.ListNode;
import org.junit.jupiter.api.Test;

import static linkedList.utils.Parser.listNodeToString;
import static linkedList.utils.Parser.stringToListNode;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        ListNode listNode = s.mergeTwoLists1(stringToListNode("[1,3]"), stringToListNode("[2,4]"));
        System.out.println(listNode);
        assertEquals("[1,2,3,4]", listNodeToString(listNode));

        listNode = s.mergeTwoLists1(stringToListNode("[1,3,4,6,8]"), stringToListNode("[1,2,4,7,8,9]"));
        System.out.println(listNode);
        assertEquals("[1,1,2,3,4,4,6,7,8,8,9]", listNodeToString(listNode));

        listNode = s.mergeTwoLists1(stringToListNode("[2,2,2]"), stringToListNode("[1,1]"));
        System.out.println(listNode);
        assertEquals("[1,1,2,2,2]", listNodeToString(listNode));

        listNode = s.mergeTwoLists1(stringToListNode("[5,6,7,8,9]"), stringToListNode("[1,2,3]"));
        System.out.println(listNode);
        assertEquals("[1,2,3,5,6,7,8,9]", listNodeToString(listNode));

        listNode = s.mergeTwoLists1(stringToListNode("[5,6]"), stringToListNode("[1,2,3,4]"));
        System.out.println(listNode);
        assertEquals("[1,2,3,4,5,6]", listNodeToString(listNode));

        listNode = s.mergeTwoLists1(null, null);
        assertNull(listNode);
    }
}
