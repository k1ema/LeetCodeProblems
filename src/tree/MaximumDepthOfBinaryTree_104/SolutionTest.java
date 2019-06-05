package tree.MaximumDepthOfBinaryTree_104;

import org.junit.Test;

import tree.utils.Parser;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(0, s.maxDepth(Parser.stringToTreeNode("[]")));
        assertEquals(1, s.maxDepth(Parser.stringToTreeNode("[1]")));
        assertEquals(3, s.maxDepth(Parser.stringToTreeNode("[3, 9, 20, null, null, 15, 7]")));
        assertEquals(4, s.maxDepth(Parser.stringToTreeNode("[1, 2, 2, 3, 3, null, null, 4, 4]")));
        assertEquals(5, s.maxDepth(Parser.stringToTreeNode("[1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, null, null, 5, 5]")));
    }
}
