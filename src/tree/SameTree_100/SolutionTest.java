package tree.SameTree_100;

import org.junit.jupiter.api.Test;
import tree.utils.Parser;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.isSameTree(Parser.stringToTreeNode("[1,2,3]"), Parser.stringToTreeNode("[1,2,3]")));
        assertFalse(s.isSameTree(Parser.stringToTreeNode("[1,2]"), Parser.stringToTreeNode("[1,null,2]")));
        assertFalse(s.isSameTree(Parser.stringToTreeNode("[1,2,1]"), Parser.stringToTreeNode("[1,1,2]")));
    }
}