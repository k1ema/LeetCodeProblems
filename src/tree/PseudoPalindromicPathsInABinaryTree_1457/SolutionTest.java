package tree.PseudoPalindromicPathsInABinaryTree_1457;

import org.junit.jupiter.api.Test;
import tree.utils.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.pseudoPalindromicPaths(Parser.stringToTreeNode("[2,3,1,3,1,null,1]")));
        assertEquals(1, s.pseudoPalindromicPaths(Parser.stringToTreeNode("[2,1,1,1,3,null,null,null,null,null,1]")));
        assertEquals(1, s.pseudoPalindromicPaths(Parser.stringToTreeNode("[9]")));
        assertEquals(2, s.pseudoPalindromicPaths(Parser.stringToTreeNode("[8,8,null,7,7,null,null,2,4,null,8,null,7,null,1]")));
    }
}