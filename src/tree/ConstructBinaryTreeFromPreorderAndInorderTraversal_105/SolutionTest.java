package tree.ConstructBinaryTreeFromPreorderAndInorderTraversal_105;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tree.utils.Parser.stringToTreeNode;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(stringToTreeNode("[3, 9, 20, null, null, 15, 7]"),
                s.buildTree(new int[] {3, 9, 20, 15, 7}, new int[] {9, 3, 15, 20, 7}));
    }
}
