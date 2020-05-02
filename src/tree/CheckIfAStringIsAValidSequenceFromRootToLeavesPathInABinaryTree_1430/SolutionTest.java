package tree.CheckIfAStringIsAValidSequenceFromRootToLeavesPathInABinaryTree_1430;

import org.junit.Test;
import tree.utils.Parser;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.isValidSequence(Parser.stringToTreeNode("[0,1,0,0,1,0,null,null,1,0,0]"), new int[] {0, 1, 0, 1}));
        assertFalse(s.isValidSequence(Parser.stringToTreeNode("[0,1,0,0,1,0,null,null,1,0,0]"), new int[] {0, 0, 1}));
        assertFalse(s.isValidSequence(Parser.stringToTreeNode("[0,1,0,0,1,0,null,null,1,0,0]"), new int[] {0, 1, 1}));
    }
}