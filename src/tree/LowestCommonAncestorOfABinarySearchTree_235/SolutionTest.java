package tree.LowestCommonAncestorOfABinarySearchTree_235;

import org.junit.jupiter.api.Test;
import tree.utils.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
//        assertEquals(6, s.lowestCommonAncestor(
//                Parser.stringToTreeNode("[6,2,8,0,4,7,9,null,null,3,5]"),
//                Parser.stringToTreeNode("[2,0,4,null,null,3,5]"),
//                Parser.stringToTreeNode("[8,7,9]")).val);
        assertEquals(2, s.lowestCommonAncestor(
                Parser.stringToTreeNode("[6,2,8,0,4,7,9,null,null,3,5]"),
                Parser.stringToTreeNode("[2,0,4,null,null,3,5]"),
                Parser.stringToTreeNode("[4,3,5]")).val);
    }
}
