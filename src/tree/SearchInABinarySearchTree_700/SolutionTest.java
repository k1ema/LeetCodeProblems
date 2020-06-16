package tree.SearchInABinarySearchTree_700;

import org.junit.Test;
import tree.utils.Parser;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Parser.stringToTreeNode("[2,1,3]"), s.searchBST(Parser.stringToTreeNode("[4,2,7,1,3]"), 2));
    }
}