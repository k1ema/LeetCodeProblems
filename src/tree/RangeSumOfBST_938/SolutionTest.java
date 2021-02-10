package tree.RangeSumOfBST_938;

import org.junit.jupiter.api.Test;
import tree.utils.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(32, s.rangeSumBST(Parser.stringToTreeNode("[10,5,15,3,7,null,18]"), 7, 15));
        assertEquals(23, s.rangeSumBST(Parser.stringToTreeNode("[10,5,15,3,7,13,18,1,null,6]"), 6, 10));
    }
}