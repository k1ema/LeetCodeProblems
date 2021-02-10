package tree.BinaryTreeTilt_563;

import org.junit.jupiter.api.Test;
import tree.utils.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.findTilt(Parser.stringToTreeNode("[1,2,3]")));
        assertEquals(15, s.findTilt(Parser.stringToTreeNode("[4,2,9,3,5,null,7]")));
        assertEquals(9, s.findTilt(Parser.stringToTreeNode("[21,7,14,1,1,2,2,3,3]")));
    }
}