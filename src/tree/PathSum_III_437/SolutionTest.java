package tree.PathSum_III_437;

import org.junit.Test;

import tree.utils.Parser;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.pathSum(Parser.stringToTreeNode("[10,5,-3,3,2,null,11,3,-2,null,1]"), 8));
        assertEquals(3, s.pathSum(Parser.stringToTreeNode("[5,4,8,11,3,-13,2,7,2,1,2,-1,5,null,6]"), 8));
        assertEquals(4, s.pathSum(Parser.stringToTreeNode("[0,1,1]"), 1));
        assertEquals(13, s.pathSum(Parser.stringToTreeNode("[1,0,1,1,2,0,-1,0,1,-1,0,-1,0,1,0]"), 2));

        assertEquals(3, s.pathSum1(Parser.stringToTreeNode("[10,5,-3,3,2,null,11,3,-2,null,1]"), 8));
        assertEquals(3, s.pathSum1(Parser.stringToTreeNode("[5,4,8,11,3,-13,2,7,2,1,2,-1,5,null,6]"), 8));
        assertEquals(4, s.pathSum1(Parser.stringToTreeNode("[0,1,1]"), 1));
        assertEquals(13, s.pathSum1(Parser.stringToTreeNode("[1,0,1,1,2,0,-1,0,1,-1,0,-1,0,1,0]"), 2));
    }
}
