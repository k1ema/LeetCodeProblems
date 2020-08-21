package linkedList.ReorderList_143;

import linkedList.utils.ListNode;
import linkedList.utils.Parser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();

        ListNode list = Parser.stringToListNode("[1,2,3,4]");
        s.reorderList(list);
        assertEquals(Parser.stringToListNode("[1,4,2,3]"), list);

        list = Parser.stringToListNode("[1,2,3,4,5]");
        s.reorderList(list);
        assertEquals(Parser.stringToListNode("[1,5,2,4,3]"), list);

        list = Parser.stringToListNode("[1]");
        s.reorderList(list);
        assertEquals(Parser.stringToListNode("[1]"), list);

        list = Parser.stringToListNode("[1,2]");
        s.reorderList(list);
        assertEquals(Parser.stringToListNode("[1,2]"), list);

        list = Parser.stringToListNode("[1,2,3]");
        s.reorderList(list);
        assertEquals(Parser.stringToListNode("[1,3,2]"), list);

        list = Parser.stringToListNode("[]");
        s.reorderList(list);
        assertEquals(Parser.stringToListNode("[]"), list);
    }
}