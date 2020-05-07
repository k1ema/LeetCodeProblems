package tree.CousinsInBinaryTree_993;

import org.junit.Test;
import tree.utils.Parser;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertFalse(s.isCousins(Parser.stringToTreeNode("[1,2,3,4]"), 4, 3));
        assertTrue(s.isCousins(Parser.stringToTreeNode("[1,2,3,null,4,null,5]"), 5, 4));
        assertFalse(s.isCousins(Parser.stringToTreeNode("[1,2,3,null,4]"), 2, 3));
    }
}