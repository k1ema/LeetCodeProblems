package tree.ConstructBinaryTreeFromString_536;

import org.junit.jupiter.api.Test;
import tree.utils.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Parser.stringToTreeNode("[4,2,6,3,1,5]"), s.str2tree("4(2(3)(1))(6(5))"));
        assertEquals(Parser.stringToTreeNode("[4,2,6,3,1,5,7]"), s.str2tree("4(2(3)(1))(6(5)(7))"));
        assertEquals(Parser.stringToTreeNode("[-4,2,6,3,1,5,7]"), s.str2tree("-4(2(3)(1))(6(5)(7))"));
        assertEquals(Parser.stringToTreeNode("[2]"), s.str2tree("2"));
        assertEquals(Parser.stringToTreeNode("[22,344]"), s.str2tree("22(344)"));
    }
}