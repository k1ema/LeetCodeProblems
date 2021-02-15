package linkedList.ReverseNodesInKGroup_25;

import linkedList.utils.Parser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Parser.stringToListNode("[2,1,4,3,5]"), s.reverseKGroup(Parser.stringToListNode("[1,2,3,4,5]"), 2));
        assertEquals(Parser.stringToListNode("[3,2,1,4,5]"), s.reverseKGroup(Parser.stringToListNode("[1,2,3,4,5]"), 3));
        assertEquals(Parser.stringToListNode("[1,2,3,4,5]"), s.reverseKGroup(Parser.stringToListNode("[1,2,3,4,5]"), 1));
        assertEquals(Parser.stringToListNode("[1]"), s.reverseKGroup(Parser.stringToListNode("[1]"), 1));
    }
}