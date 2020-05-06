package tree.KthSmallestElementInA_BST_230;

import org.junit.Test;
import tree.utils.Parser;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.kthSmallest(Parser.stringToTreeNode("[3,1,4,null,2]"), 1));
        assertEquals(3, s.kthSmallest(Parser.stringToTreeNode("[5,3,6,2,4,null,null,1]"), 3));
    }
}