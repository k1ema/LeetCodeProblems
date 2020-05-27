package tree.LowestCommonAncestorOfABinaryTree_236;

import org.junit.Test;
import tree.utils.Parser;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.lowestCommonAncestor(
                Parser.stringToTreeNode("[3,5,1,6,2,0,8,null,null,7,4]"),
                Parser.stringToTreeNode("[5,6,2,null,null,7,4]"),
                Parser.stringToTreeNode("[1,0,8]")).val);
        assertEquals(5, s.lowestCommonAncestor(
                Parser.stringToTreeNode("[3,5,1,6,2,0,8,null,null,7,4]"),
                Parser.stringToTreeNode("[5,6,2,null,null,7,4]"),
                Parser.stringToTreeNode("[4,null,null]")).val);
        assertEquals(48, s.lowestCommonAncestor(
                Parser.stringToTreeNode("[37,-34,-48,null,-100,-101,48,null,null,null,null,-54,null,-71,-22,null,null,null,8]"),
                Parser.stringToTreeNode("[-71,null,null]"),
                Parser.stringToTreeNode("[48,-54,null,-71,-22,null,null,null,8]")).val);
        assertEquals(3, s.lowestCommonAncestor(
                Parser.stringToTreeNode("[3,5,1,6,2,0,8,null,null,7,4]"),
                Parser.stringToTreeNode("[7]"),
                Parser.stringToTreeNode("[0]")).val);
    }
}
