package tree.ValidateBinarySearchTree_98;

import org.junit.jupiter.api.Test;
import tree.utils.Parser;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.isValidBST(Parser.stringToTreeNode("[2, 1, 3]")));
        assertFalse(s.isValidBST(Parser.stringToTreeNode("[5,1,4,null,null,3,6]")));
        assertTrue(s.isValidBST(Parser.stringToTreeNode("[7,3,10,2,5,8,11,null,null,4,null]")));
        assertTrue(s.isValidBST(Parser.stringToTreeNode("[0,-1]")));
        assertFalse(s.isValidBST(Parser.stringToTreeNode("[10,5,15,null,null,6,20]")));
    }
}
