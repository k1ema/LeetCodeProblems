package tree.DeleteNodeInaBST_450;

import org.junit.jupiter.api.Test;
import tree.utils.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Parser.stringToTreeNode("[5,4,6,2,null,null,7]"),
                s.deleteNode(Parser.stringToTreeNode("[5,3,6,2,4,null,7]"), 3));
        assertEquals(Parser.stringToTreeNode("[5,4,6,2,null,null,7]"),
                s.deleteNode(Parser.stringToTreeNode("[5,4,6,2,null,null,7]"), 3));
        assertNull(s.deleteNode(Parser.stringToTreeNode("[5]"), 5));
    }
}