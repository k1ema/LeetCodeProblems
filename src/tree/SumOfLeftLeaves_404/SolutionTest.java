package tree.SumOfLeftLeaves_404;

import org.junit.Test;
import tree.utils.Parser;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(24, s.sumOfLeftLeaves(Parser.stringToTreeNode("[3,9,20,null,null,15,7]")));
        assertEquals(4, s.sumOfLeftLeaves(Parser.stringToTreeNode("[1,2,3,4,5]")));
        assertEquals(10, s.sumOfLeftLeaves(Parser.stringToTreeNode("[1,2,3,4,5,6]")));
    }
}