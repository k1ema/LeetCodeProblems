package linkedList.ConvertBinaryNumberInALinkedListToInteger_1290;

import linkedList.utils.Parser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(5, s.getDecimalValue(Parser.stringToListNode("[1,0,1]")));
        assertEquals(0, s.getDecimalValue(Parser.stringToListNode("[0]")));
        assertEquals(1, s.getDecimalValue(Parser.stringToListNode("[1]")));
        assertEquals(0, s.getDecimalValue(Parser.stringToListNode("[0,0]")));
        assertEquals(18880, s.getDecimalValue(Parser.stringToListNode("[1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]")));
    }
}