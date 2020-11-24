package dynamic.HouseRobber_III_337;

import org.junit.Test;
import tree.utils.Parser;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(7, s.rob(Parser.stringToTreeNode("[3,2,3,null,3,null,1]")));
        assertEquals(9, s.rob(Parser.stringToTreeNode("[3,4,5,1,3,null,1]")));
        assertEquals(1, s.rob(Parser.stringToTreeNode("[1]")));
    }
}