package linkedList.SwappingNodesInALinkedList_1721;

import linkedList.utils.Parser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Parser.stringToListNode("[1,4,3,2,5]"), s.swapNodes(Parser.stringToListNode("[1,2,3,4,5]"), 2));
        assertEquals(Parser.stringToListNode("[7,9,6,6,8,7,3,0,9,5]"), s.swapNodes(Parser.stringToListNode("[7,9,6,6,7,8,3,0,9,5]"), 5));
        assertEquals(Parser.stringToListNode("[1]"), s.swapNodes(Parser.stringToListNode("[1]"), 1));
        assertEquals(Parser.stringToListNode("[2,1]"), s.swapNodes(Parser.stringToListNode("[1,2]"), 1));
        assertEquals(Parser.stringToListNode("[1,2,3]"), s.swapNodes(Parser.stringToListNode("[1,2,3]"), 2));
    }
}