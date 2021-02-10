package tree.ConstructBinaryTreeFromPreorderAndPostorderTraversal_889;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tree.utils.Parser.stringToTreeNode;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(stringToTreeNode("[1,2,3,4,5,6]"),
                s.constructFromPrePost(new int[] {1, 2, 4, 5, 3, 6},
                        new int[] {4, 5, 2, 6, 3, 1}));
        assertEquals(stringToTreeNode("[1,2,3,4,5,6,7]"),
                s.constructFromPrePost(new int[] {1, 2, 4, 5, 3, 6, 7},
                        new int[] {4, 5, 2, 6, 7, 3, 1}));
        assertEquals(stringToTreeNode("[1,2,3,4,5,6,7,8,9,10,11]"),
                s.constructFromPrePost(new int[] {1, 2, 4, 8, 9, 5, 10, 11, 3, 6, 7},
                        new int[] {8, 9, 4, 10, 11, 5, 2, 6, 7, 3, 1}));
        assertEquals(stringToTreeNode("[1,2,3,4,5,6,7,8,9,10]"),
                s.constructFromPrePost(new int[] {1, 2, 4, 8, 9, 5, 10, 3, 6, 7},
                        new int[] {8, 9, 4, 10, 5, 2, 6, 7, 3, 1}));
        assertEquals(stringToTreeNode("[2,1]"),
                s.constructFromPrePost(new int[] {2, 1}, new int[] {1, 2}));
    }
}
