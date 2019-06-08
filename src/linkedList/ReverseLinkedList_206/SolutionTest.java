package linkedList.ReverseLinkedList_206;

import org.junit.Test;

import linkedList.utils.Parser;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Parser.stringToListNode("[5,4,3,2,1]"), s.reverseList(Parser.stringToListNode("[1,2,3,4,5]")));
        assertEquals(Parser.stringToListNode("[1]"), s.reverseList(Parser.stringToListNode("[1]")));
        assertEquals(Parser.stringToListNode("[5,4,3,2,1]"), s.reverseList1(Parser.stringToListNode("[1,2,3,4,5]")));
        assertEquals(Parser.stringToListNode("[1]"), s.reverseList1(Parser.stringToListNode("[1]")));
    }
}
