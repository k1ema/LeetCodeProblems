package tree.InvertBinaryTree_226;

import org.junit.jupiter.api.Test;
import tree.utils.Parser;
import tree.utils.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        TreeNode result = s.invertTree(Parser.stringToTreeNode("[4,2,7,1,3,6,9]"));
        assertEquals(Parser.stringToTreeNode("[4,7,2,9,6,3,1]"), result);

        result = s.invertTree(Parser.stringToTreeNode("[1,3,2,5,null,null,null]"));
        assertEquals(Parser.stringToTreeNode("[1,2,3,null,null,null,5]"), result);
    }
}
