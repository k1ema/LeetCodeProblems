package tree.DiameterOfBinaryTree_543;

import org.junit.jupiter.api.Test;
import tree.utils.Parser;
import tree.utils.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.diameterOfBinaryTree(Parser.stringToTreeNode("[1,2,3,4,5]")));

        assertEquals(0, s.diameterOfBinaryTree(Parser.stringToTreeNode("[]")));
        assertEquals(0, s.diameterOfBinaryTree(Parser.stringToTreeNode("[1]")));

        TreeNode tree = Parser.stringToTreeNode("[1,2,3,4,5,null,7,null,null,null,null,8,9,10,null,11,null,null,null,12]");
        assertEquals(7, s.diameterOfBinaryTree(tree));

        tree = Parser.stringToTreeNode("[4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]");
        assertEquals(8, s.diameterOfBinaryTree(tree));
    }
}