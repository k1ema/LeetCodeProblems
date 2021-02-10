package linkedList.RemoveNthNodeFromEndOfList_19;

import org.junit.jupiter.api.Test;

import static linkedList.utils.Parser.stringToListNode;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(stringToListNode("[1,2,3,5]"),
                s.removeNthFromEnd(stringToListNode("[1,2,3,4,5]"), 2));
        assertNull(s.removeNthFromEnd(stringToListNode("[1]"), 1));
        assertEquals(stringToListNode("[1]"),
                s.removeNthFromEnd(stringToListNode("[1,2]"), 1));
        assertEquals(stringToListNode("[2]"),
                s.removeNthFromEnd(stringToListNode("[1,2]"), 2));
    }
}
