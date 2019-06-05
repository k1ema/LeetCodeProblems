package tree.MinimumDepthOfBinaryTree_111;

import java.util.stream.Stream;

import org.junit.Test;

import tree.utils.Parser;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(0, s.minDepth(Parser.stringToTreeNode("[]")));
        assertEquals(1, s.minDepth(Parser.stringToTreeNode("[1]")));
        assertEquals(2, s.minDepth(Parser.stringToTreeNode("[1, 2]")));
        assertEquals(2, s.minDepth(Parser.stringToTreeNode("[1, 2, 2, 3]")));
        assertEquals(2, s.minDepth(Parser.stringToTreeNode("[3, 9, 20, null, null, 15, 7]")));
        assertEquals(2, s.minDepth(Parser.stringToTreeNode("[1, 2, 2, 3, 3, null, null, 4, 4]")));
        assertEquals(3, s.minDepth(Parser.stringToTreeNode("[1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, null, null, 5, 5]")));
        assertEquals(3, s.minDepth(Parser.stringToTreeNode("[1, 2, 3, 4, null, null, 5]")));
        assertEquals(5, s.minDepth(Parser.stringToTreeNode("[1, 2, null, 3, null, 4, null, 5]")));
    }
}