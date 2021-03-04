package linkedList.IntersectionOfTwoLinkedLists_160;

import org.junit.jupiter.api.Test;

import static linkedList.utils.Parser.stringToListNode;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(stringToListNode("[1,8,4,5]"), s.getIntersectionNode(stringToListNode("[4,1,8,4,5]"), stringToListNode("[5,0,1,8,4,5]")));
        assertEquals(stringToListNode("[2,4]"), s.getIntersectionNode(stringToListNode("[0,9,1,2,4]"), stringToListNode("[3,2,4]")));
        assertNull(s.getIntersectionNode(stringToListNode("[2,6,4]"), stringToListNode("[1,5]")));
        assertNull(s.getIntersectionNode(stringToListNode("[2]"), stringToListNode("[1]")));
        assertNull(s.getIntersectionNode(null, null));
    }
}
