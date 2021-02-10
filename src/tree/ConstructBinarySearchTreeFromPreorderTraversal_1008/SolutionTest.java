package tree.ConstructBinarySearchTreeFromPreorderTraversal_1008;

import org.junit.jupiter.api.Test;
import tree.utils.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Parser.stringToTreeNode("[8,5,10,1,7,null,12]"), s.bstFromPreorder(new int[] {8, 5, 1, 7, 10, 12}));
        assertEquals(Parser.stringToTreeNode("[4,3,null,2,null,1,null]"), s.bstFromPreorder(new int[] {4, 3, 2, 1}));
        assertEquals(Parser.stringToTreeNode("[1,null,2,null,3,null,4]"), s.bstFromPreorder(new int[] {1, 2, 3, 4}));
    }
}