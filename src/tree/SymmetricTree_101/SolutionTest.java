package tree.SymmetricTree_101;

import org.junit.jupiter.api.Test;
import tree.utils.Parser;
import tree.utils.TreeNode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        TreeNode tree = Parser.stringToTreeNode("[1, 2, 2, 3, 4, 4, 3, 5, 6, 7, 8, 8, 7, 6, 5]");
        assertTrue(s.isSymmetric(tree));

        tree = Parser.stringToTreeNode("[1,2,2,null,3,null,3]");
        System.out.println(tree);
        assertFalse(s.isSymmetric(tree));
    }
}
