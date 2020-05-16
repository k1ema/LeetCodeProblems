package tree.CountGoodNodesInBinaryTree_1448;

import org.junit.Test;
import tree.utils.Parser;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(4, s.goodNodes(Parser.stringToTreeNode("[3,1,4,3,null,1,5]")));
        assertEquals(3, s.goodNodes(Parser.stringToTreeNode("[3,3,null,4,2]")));
        assertEquals(1, s.goodNodes(Parser.stringToTreeNode("[1]")));
    }
}