package tree.AddOneRowToTree_623;

import org.junit.jupiter.api.Test;
import tree.utils.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Parser.stringToTreeNode("[4,1,1,2,null,null,6,3,1,5]"), s.addOneRow(Parser.stringToTreeNode("[4,2,6,3,1,5]"), 1, 2));
        assertEquals(Parser.stringToTreeNode("[4,2,null,1,1,3,null,null,1]"), s.addOneRow(Parser.stringToTreeNode("[4,2,null,3,1]"), 1, 3));
        assertEquals(Parser.stringToTreeNode("[4,2,6,1,1,1,1,3,null,null,1,5,null,null,null,1,2,3,4,5,6]"),
                s.addOneRow(Parser.stringToTreeNode("[4,2,6,3,1,5,null,1,2,3,4,5,6]"), 1, 3));
    }
}