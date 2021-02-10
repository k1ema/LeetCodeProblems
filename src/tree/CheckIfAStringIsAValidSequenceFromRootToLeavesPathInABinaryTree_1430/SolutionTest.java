package tree.CheckIfAStringIsAValidSequenceFromRootToLeavesPathInABinaryTree_1430;

import org.junit.jupiter.api.Test;
import tree.utils.Parser;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.isValidSequence(Parser.stringToTreeNode("[0,1,0,0,1,0,null,null,1,0,0]"), new int[] {0, 1, 0, 1}));
        assertFalse(s.isValidSequence(Parser.stringToTreeNode("[0,1,0,0,1,0,null,null,1,0,0]"), new int[] {0, 0, 1}));
        assertFalse(s.isValidSequence(Parser.stringToTreeNode("[0,1,0,0,1,0,null,null,1,0,0]"), new int[] {0, 1, 1}));
    }
}