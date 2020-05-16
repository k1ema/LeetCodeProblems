package linkedList.OddEvenLinkedList_328;

import linkedList.utils.Parser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Parser.stringToListNode("[1,3,5,2,4]"), s.oddEvenList(Parser.stringToListNode("[1,2,3,4,5]")));
        assertEquals(Parser.stringToListNode("[2,3,6,7,1,5,4]"), s.oddEvenList(Parser.stringToListNode("[2,1,3,5,6,4,7]")));
        assertEquals(Parser.stringToListNode("[1,3,5,7,2,4,6,8]"), s.oddEvenList(Parser.stringToListNode("[1,2,3,4,5,6,7,8]")));
        assertEquals(Parser.stringToListNode("[1,2]"), s.oddEvenList(Parser.stringToListNode("[1,2]")));
        assertEquals(Parser.stringToListNode("[1]"), s.oddEvenList(Parser.stringToListNode("[1]")));
    }
}