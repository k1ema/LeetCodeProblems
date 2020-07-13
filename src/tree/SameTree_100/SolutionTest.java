package tree.SameTree_100;

import org.junit.Test;
import tree.utils.Parser;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.isSameTree(Parser.stringToTreeNode("[1,2,3]"), Parser.stringToTreeNode("[1,2,3]")));
        assertFalse(s.isSameTree(Parser.stringToTreeNode("[1,2]"), Parser.stringToTreeNode("[1,null,2]")));
        assertFalse(s.isSameTree(Parser.stringToTreeNode("[1,2,1]"), Parser.stringToTreeNode("[1,1,2]")));
    }
}