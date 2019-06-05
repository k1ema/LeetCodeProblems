package tree.BalancedBinaryTree_110;

import org.junit.Test;

import tree.utils.Parser;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.isBalanced(Parser.stringToTreeNode("[3, 9, 20, null, null, 15, 7]")));
        assertFalse(s.isBalanced(Parser.stringToTreeNode("[1, 2, 2, 3, 3, null, null, 4, 4]")));
        assertTrue(s.isBalanced(Parser.stringToTreeNode("[]")));
        assertTrue(s.isBalanced(Parser.stringToTreeNode("[1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, null, null, 5, 5]")));
    }
}
