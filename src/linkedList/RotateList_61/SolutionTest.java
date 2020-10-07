package linkedList.RotateList_61;

import linkedList.utils.Parser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Parser.stringToListNode("[1,2,3,4,5]"), s.rotateRight(Parser.stringToListNode("[1,2,3,4,5]"), 0));
        assertEquals(Parser.stringToListNode("[4,5,1,2,3]"), s.rotateRight(Parser.stringToListNode("[1,2,3,4,5]"), 2));
        assertEquals(Parser.stringToListNode("[1,2,3,4,5]"), s.rotateRight(Parser.stringToListNode("[1,2,3,4,5]"), 5));
        assertEquals(Parser.stringToListNode("[2,0,1]"), s.rotateRight(Parser.stringToListNode("[0,1,2]"), 4));
    }
}