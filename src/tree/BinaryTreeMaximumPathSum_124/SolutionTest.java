package tree.BinaryTreeMaximumPathSum_124;

import org.junit.Test;
import tree.utils.Parser;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(6, s.maxPathSum(Parser.stringToTreeNode("[1,2,3]")));
        assertEquals(42, s.maxPathSum(Parser.stringToTreeNode("[-10,9,20,null,null,15,7]")));
        assertEquals(48, s.maxPathSum(Parser.stringToTreeNode("[5,4,8,11,null,13,4,7,2,null,null,null,1]")));
    }
}