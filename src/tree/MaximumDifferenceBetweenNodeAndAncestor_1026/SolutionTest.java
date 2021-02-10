package tree.MaximumDifferenceBetweenNodeAndAncestor_1026;

import org.junit.jupiter.api.Test;
import tree.utils.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(7, s.maxAncestorDiff(Parser.stringToTreeNode("[8,3,10,1,6,null,14,null,null,4,7,13]")));
        assertEquals(3, s.maxAncestorDiff(Parser.stringToTreeNode("[1,null,2,null,0,3]")));
    }
}