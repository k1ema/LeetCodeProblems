package linkedList.LinkedListCycle_II_142;

import org.junit.Test;

import static linkedList.utils.Parser.stringToListNode;
import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.detectCycle(stringToListNode("[3,2,0,-4,2,0,-4,2,0,-4]")).val);
    }
}