package tree.SumOfRootToLeafBinaryNumbers_1022;

import org.junit.jupiter.api.Test;
import tree.utils.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(22, s.sumRootToLeaf(Parser.stringToTreeNode("[1,0,1,0,1,0,1]")));
        assertEquals(11, s.sumRootToLeaf(Parser.stringToTreeNode("[1,0,1,null,1,0,null]")));
    }
}