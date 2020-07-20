package linkedList.RemoveLinkedListElements_203;

import linkedList.utils.Parser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Parser.stringToListNode("[1,2,3,4,5]"), s.removeElements(Parser.stringToListNode("[1,2,6,3,4,5,6]"), 6));
        assertEquals(Parser.stringToListNode("[1,2,3,4,5]"), s.removeElements(Parser.stringToListNode("[1,2,6,6,6,3,4,5,6]"), 6));
        assertEquals(Parser.stringToListNode("[]"), s.removeElements(Parser.stringToListNode("[6,6,6]"), 6));
    }
}