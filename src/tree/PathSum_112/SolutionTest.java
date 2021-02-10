package tree.PathSum_112;

import org.junit.jupiter.api.Test;
import tree.utils.Parser;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.hasPathSum(Parser.stringToTreeNode("[5,4,8,11,null,13,4,7,2,null,null,null,1]"), 22));
        assertFalse(s.hasPathSum(null, 0));
        assertFalse(s.hasPathSum(Parser.stringToTreeNode("[1,2]"), 1));
        assertTrue(s.hasPathSum(Parser.stringToTreeNode("[1]"), 1));
    }
}
