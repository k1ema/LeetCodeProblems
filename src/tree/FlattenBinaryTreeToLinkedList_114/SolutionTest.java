package tree.FlattenBinaryTreeToLinkedList_114;

import org.junit.jupiter.api.Test;
import tree.utils.Parser;
import tree.utils.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        TreeNode tree = Parser.stringToTreeNode("[1,2,5,3,4,null,6]");
        s.flatten(tree);
        assertEquals(Parser.stringToTreeNode("[1,null,2,null,3,null,4,null,5,null,6]"), tree);
    }
}