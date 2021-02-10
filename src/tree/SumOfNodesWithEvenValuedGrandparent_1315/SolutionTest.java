package tree.SumOfNodesWithEvenValuedGrandparent_1315;

import org.junit.jupiter.api.Test;
import tree.utils.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(18, s.sumEvenGrandparent(Parser.stringToTreeNode("[6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]")));
    }
}