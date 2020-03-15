package tree.SumRootToLeafNumbers_129;

import org.junit.Test;
import tree.utils.Parser;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(25, s.sumNumbers(Parser.stringToTreeNode("[1,2,3]")));
        assertEquals(1026, s.sumNumbers(Parser.stringToTreeNode("[4,9,0,5,1]")));
        assertEquals(495, s.sumNumbers(Parser.stringToTreeNode("[4,9,null,5]")));
        assertEquals(495, s.sumNumbers(Parser.stringToTreeNode("[4,null,9,null,5]")));
        assertEquals(26588, s.sumNumbers(Parser.stringToTreeNode("[4,9,0,5,1,6,3,2,1,null,null,2,3,4,5]")));
    }
}