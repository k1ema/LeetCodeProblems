package tree.BinaryTreeLevelOrderTraversal_102;

import org.junit.Test;
import tree.utils.TreeNode;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static tree.utils.Parser.stringToTreeNode;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(Arrays.asList(3), Arrays.asList(9, 20), Arrays.asList(15, 7)),
                s.levelOrder(stringToTreeNode("[3,9,20,null,null,15,7]")));
        assertEquals(Arrays.asList(Arrays.asList(10), Arrays.asList(5, 15), Arrays.asList(1, 12, 20)),
                s.levelOrder(stringToTreeNode("[10,5,15,1,null,12,20]")));
        assertEquals(Collections.emptyList(), s.levelOrder(null));
        assertEquals(Collections.singletonList(Collections.singletonList(1)), s.levelOrder(new TreeNode(1)));
        assertEquals(Arrays.asList(Collections.singletonList(1), Collections.singletonList(2),
                Collections.singletonList(3), Collections.singletonList(4), Collections.singletonList(5)),
                s.levelOrder(stringToTreeNode("[1,2,null,3,null,4,null,5]")));
    }
}
