package tree.InorderSuccessorInBST_285;

import org.junit.Test;
import tree.utils.Parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Parser.stringToTreeNode("[2,1,3]"),
                s.inorderSuccessor(Parser.stringToTreeNode("[2,1,3]"), Parser.stringToTreeNode("[1]")));
        assertNull(s.inorderSuccessor(Parser.stringToTreeNode("[5,3,6,2,4,null,null,1]"), Parser.stringToTreeNode("[6]")));
        assertEquals(Parser.stringToTreeNode("[3,2,4,1]"),
                s.inorderSuccessor(Parser.stringToTreeNode("[5,3,6,2,4,null,null,1]"), Parser.stringToTreeNode("[2,1,null]")));
    }
}