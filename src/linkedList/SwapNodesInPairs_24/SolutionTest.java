package linkedList.SwapNodesInPairs_24;

import linkedList.utils.Parser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Parser.stringToListNode("[2,1,4,3]"), s.swapPairs(Parser.stringToListNode("[1,2,3,4]")));
        assertEquals(Parser.stringToListNode("[2,1,4,3,5]"), s.swapPairs(Parser.stringToListNode("[1,2,3,4,5]")));
        assertEquals(Parser.stringToListNode("[1]"), s.swapPairs(Parser.stringToListNode("[1]")));
        assertNull(s.swapPairs(null));
    }
}