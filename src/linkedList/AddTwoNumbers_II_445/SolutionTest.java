package linkedList.AddTwoNumbers_II_445;

import linkedList.utils.Parser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Parser.stringToListNode("[7,8,0,7]"),
                s.addTwoNumbers(Parser.stringToListNode("[7,2,4,3]"), Parser.stringToListNode("[5,6,4]")));
        assertEquals(Parser.stringToListNode("[1,0]"),
                s.addTwoNumbers(Parser.stringToListNode("[5]"), Parser.stringToListNode("[5]")));
        assertEquals(Parser.stringToListNode("[1,0,0,0,0,0]"),
                s.addTwoNumbers(Parser.stringToListNode("[1]"), Parser.stringToListNode("[9,9,9,9,9]")));
    }
}