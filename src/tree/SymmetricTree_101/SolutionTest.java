package tree.SymmetricTree_101;

import org.junit.Assert;
import org.junit.Test;

import tree.utils.Parser;
import tree.utils.TreeNode;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        TreeNode tree = Parser.stringToTreeNode("[1, 2, 2, 3, 4, 4, 3, 5, 6, 7, 8, 8, 7, 6, 5]");
        Assert.assertTrue(s.isSymmetric(tree));

        tree = Parser.stringToTreeNode("[1,2,2,null,3,null,3]");
        System.out.println(tree);
        Assert.assertFalse(s.isSymmetric(tree));
    }
}
