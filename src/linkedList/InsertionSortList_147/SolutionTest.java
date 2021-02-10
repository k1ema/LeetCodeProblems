package linkedList.InsertionSortList_147;

import linkedList.utils.Parser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Parser.stringToListNode("[1,2,3,4]"), s.insertionSortList(Parser.stringToListNode("[4,2,1,3]")));
        assertEquals(Parser.stringToListNode("[1,2,3,4]"), s.insertionSortList(Parser.stringToListNode("[4,3,2,1]")));
        assertEquals(Parser.stringToListNode("[1,2,3,4]"), s.insertionSortList(Parser.stringToListNode("[1,4,3,2]")));
        assertEquals(Parser.stringToListNode("[-1,0,3,4,5]"), s.insertionSortList(Parser.stringToListNode("[-1,5,3,4,0]")));
        assertEquals(Parser.stringToListNode("[1,1]"), s.insertionSortList(Parser.stringToListNode("[1,1]")));
    }
}