package stack.BinaryTreeInorderTraversal_94;

import java.util.Arrays;

import org.junit.Test;

import tree.utils.Parser;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(1, 3, 2), s.inorderTraversal(Parser.stringToTreeNode("[1,null,2,3]")));
        assertEquals(Arrays.asList(4, 10, 12, 15, 18, 22, 24, 25, 31, 35, 44, 50, 66, 70, 90),
                s.inorderTraversal(Parser.stringToTreeNode("[25, 15, 50, 10, 22, 35, 70, 4, 12, 18, 24, 31, 44, 66, 90]")));
        assertEquals(Arrays.asList(4, 2, 5, 1, 6, 3),
                s.inorderTraversal(Parser.stringToTreeNode("[1,2,3,4,5,6,null]")));
    }
}
