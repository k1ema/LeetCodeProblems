package tree.LowestCommonAncestorOfABinaryTree_II_1644;

import org.junit.jupiter.api.Test;
import tree.utils.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Parser.stringToTreeNode("[3,5,1,6,2,0,8,null,null,7,4]"),
                s.lowestCommonAncestor(Parser.stringToTreeNode("[3,5,1,6,2,0,8,null,null,7,4]"),
                        Parser.stringToTreeNode("[5,6,2,null,null,7,4]"), Parser.stringToTreeNode("[1,0,8]")));
        assertEquals(Parser.stringToTreeNode("[5,6,2,null,null,7,4]"),
                s.lowestCommonAncestor(Parser.stringToTreeNode("[3,5,1,6,2,0,8,null,null,7,4]"),
                        Parser.stringToTreeNode("[5,6,2,null,null,7,4]"), Parser.stringToTreeNode("[4]")));
        assertNull(s.lowestCommonAncestor(Parser.stringToTreeNode("[3,5,1,6,2,0,8,null,null,7,4]"),
                Parser.stringToTreeNode("[5,6,2,null,null,7,4]"), Parser.stringToTreeNode("[10]")));
    }
}