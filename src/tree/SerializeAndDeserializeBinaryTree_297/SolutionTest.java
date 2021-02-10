package tree.SerializeAndDeserializeBinaryTree_297;

import org.junit.jupiter.api.Test;
import tree.utils.Parser;
import tree.utils.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();

        TreeNode root = Parser.stringToTreeNode("[2,1,3]");
        assertEquals(root, s.deserialize(s.serialize(root)));

        root = Parser.stringToTreeNode("[10, 5, 15, 3, 6, 12, 17]");
        assertEquals(root, s.deserialize(s.serialize(root)));

        root = Parser.stringToTreeNode("[10, 5, 15, null, 6, 12, 17]");
        assertEquals(root, s.deserialize(s.serialize(root)));

        root = Parser.stringToTreeNode("[10, null, 15, null, 20]");
        assertEquals(root, s.deserialize(s.serialize(root)));

        root = Parser.stringToTreeNode("[10, 5, null, 1]");
        assertEquals(root, s.deserialize(s.serialize(root)));

        root = Parser.stringToTreeNode("[5,3,6,2,4,null,null,1]");
        assertEquals(root, s.deserialize(s.serialize(root)));
    }
}