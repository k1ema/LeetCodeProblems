package linkedList.RemoveDuplicatesFromSortedList_II_82;

import linkedList.utils.Parser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Parser.stringToListNode("[1,2,5]"), s.deleteDuplicates(Parser.stringToListNode("[1,2,3,3,4,4,5]")));
        assertEquals(Parser.stringToListNode("[2,3]"), s.deleteDuplicates(Parser.stringToListNode("[1,1,1,2,3]")));
        assertEquals(Parser.stringToListNode("[1,2]"), s.deleteDuplicates(Parser.stringToListNode("[1,2,3,3,3]")));
        assertEquals(Parser.stringToListNode("[]"), s.deleteDuplicates(Parser.stringToListNode("[1,1,3,3,3]")));
        assertEquals(Parser.stringToListNode("[]"), s.deleteDuplicates(Parser.stringToListNode("[1,1,1]")));
    }
}