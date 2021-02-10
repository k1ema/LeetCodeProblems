package tree.BinaryTreeLevelOrderTraversal_II_107;

import org.junit.jupiter.api.Test;
import tree.utils.TreeNode;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tree.utils.Parser.stringToTreeNode;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(Arrays.asList(15, 7), Arrays.asList(9, 20), Arrays.asList(3)),
                s.levelOrderBottom(stringToTreeNode("[3,9,20,null,null,15,7]")));
        assertEquals(Arrays.asList(Arrays.asList(1, 12, 20), Arrays.asList(5, 15), Arrays.asList(10)),
                s.levelOrderBottom(stringToTreeNode("[10,5,15,1,null,12,20]")));
        assertEquals(Arrays.asList(Arrays.asList(1, 2,3,4,5,6,7,8), Arrays.asList(1,6,12,20), Arrays.asList(5,15), Collections.singletonList(10)),
                s.levelOrderBottom(stringToTreeNode("[10,5,15,1,6,12,20,1,2,3,4,5,6,7,8]")));
        assertEquals(Collections.emptyList(), s.levelOrderBottom(null));
        assertEquals(Collections.singletonList(Collections.singletonList(1)), s.levelOrderBottom(new TreeNode(1)));
        assertEquals(Arrays.asList(Collections.singletonList(5), Collections.singletonList(4),
                Collections.singletonList(3), Collections.singletonList(2), Collections.singletonList(1)),
                s.levelOrderBottom(stringToTreeNode("[1,2,null,3,null,4,null,5]")));
    }
}
