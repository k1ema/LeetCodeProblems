package linkedList.LinkedListCycle_141;

import org.junit.Assert;
import org.junit.Test;

import static linkedList.utils.Parser.stringToListNode;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertTrue(s.hasCycle(stringToListNode("[3,2,0,-4,2,0,-4]")));
        Assert.assertFalse(s.hasCycle(stringToListNode("[1,2]")));
    }
}
