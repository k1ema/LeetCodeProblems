package tree.FindNearestRightNodeInBinaryTree_1602;

import org.junit.jupiter.api.Test;
import tree.utils.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Parser.stringToTreeNode("[5]"),
                s.findNearestRightNode(Parser.stringToTreeNode("[1,2,3,null,4,5,6]"), Parser.stringToTreeNode("[4]")));
        assertEquals(null, s.findNearestRightNode(Parser.stringToTreeNode("[3,null,4,2]"), Parser.stringToTreeNode("[2]")));
        assertEquals(null, s.findNearestRightNode(Parser.stringToTreeNode("[1]"), Parser.stringToTreeNode("[1]")));
        assertEquals(Parser.stringToTreeNode("[2,null,1]"),
                s.findNearestRightNode(Parser.stringToTreeNode("[3,4,2,null,null,null,1]"), Parser.stringToTreeNode("[4]")));
    }
}