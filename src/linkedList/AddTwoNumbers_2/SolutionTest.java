package linkedList.AddTwoNumbers_2;

import org.junit.Test;

import static linkedList.utils.Parser.stringToListNode;
import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(stringToListNode("[7,0,8]"),
                s.addTwoNumbers(stringToListNode("[2,4,3]"), stringToListNode("[5,6,4]")));
        assertEquals(stringToListNode("[0,0,0,0,0,0,1]"),
                s.addTwoNumbers(stringToListNode("[9]"), stringToListNode("[1,9,9,9,9,9]")));
        assertEquals(stringToListNode("[0]"),
                s.addTwoNumbers(stringToListNode("[0]"), stringToListNode("[0]")));
        assertEquals(stringToListNode("[0,1]"),
                s.addTwoNumbers(stringToListNode("[5]"), stringToListNode("[5]")));
        assertEquals(stringToListNode("[0,0,1]"),
                s.addTwoNumbers(stringToListNode("[1]"), stringToListNode("[9,9]")));
        assertEquals(stringToListNode("[2,0,1]"),
                s.addTwoNumbers(stringToListNode("[3,7]"), stringToListNode("[9,2]")));
    }
}
