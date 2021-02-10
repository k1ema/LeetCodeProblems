package linkedList.LinkedListCycle_141;

import org.junit.jupiter.api.Test;

import static linkedList.utils.Parser.stringToListNode;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.hasCycle(stringToListNode("[3,2,0,-4,2,0,-4]")));
        assertFalse(s.hasCycle(stringToListNode("[1,2]")));
    }
}
