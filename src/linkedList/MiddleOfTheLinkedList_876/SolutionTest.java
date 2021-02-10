package linkedList.MiddleOfTheLinkedList_876;

import linkedList.utils.Parser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Parser.stringToListNode("[3,4,5]"), s.middleNode(Parser.stringToListNode("[1,2,3,4,5]")));
        assertEquals(Parser.stringToListNode("[4,5,6]"), s.middleNode(Parser.stringToListNode("[1,2,3,4,5,6]")));
        assertEquals(Parser.stringToListNode("[1]"), s.middleNode(Parser.stringToListNode("[1]")));
        assertEquals(Parser.stringToListNode("[2]"), s.middleNode(Parser.stringToListNode("[1,2]")));
    }
}
