package tree.RecoverBinarySearchTree_99;

import org.junit.Test;
import tree.utils.Parser;
import tree.utils.TreeNode;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        TreeNode root = Parser.stringToTreeNode("[1,3,null,null,2]");
        TreeNode expected = Parser.stringToTreeNode("[3,1,null,null,2]");
        s.recoverTree(root);
        assertEquals(expected, root);

        root = Parser.stringToTreeNode("[3,1,4,null,null,2]");
        expected = Parser.stringToTreeNode("[2,1,4,null,null,3]");
        s.recoverTree(root);
        assertEquals(expected, root);
    }
}