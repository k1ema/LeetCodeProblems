package tree.TwoSumBSTs_1214;

import org.junit.Test;
import tree.utils.Parser;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.twoSumBSTs(Parser.stringToTreeNode("[2, 1, 4]"), Parser.stringToTreeNode("[1, 0, 3]"), 5));
        assertFalse(s.twoSumBSTs(Parser.stringToTreeNode("[0, -10, 10]"),
                Parser.stringToTreeNode("[5, 1, 7, 0, 2]"), 18));
        assertTrue(s.twoSumBSTs(Parser.stringToTreeNode("[2]"), Parser.stringToTreeNode("[1]"), 3));
        assertFalse(s.twoSumBSTs(Parser.stringToTreeNode("[2]"), Parser.stringToTreeNode("[]"), 3));
    }
}
