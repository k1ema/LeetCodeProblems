package tree.InsertIntoABinarySearchTree_701;

import org.junit.jupiter.api.Test;
import tree.utils.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Parser.stringToTreeNode("[4,2,7,1,3,5]"),
                s.insertIntoBST(Parser.stringToTreeNode("[4,2,7,1,3]"), 5));
    }
}