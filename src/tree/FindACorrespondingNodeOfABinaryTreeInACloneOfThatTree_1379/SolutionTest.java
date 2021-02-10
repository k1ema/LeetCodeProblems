package tree.FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree_1379;

import org.junit.jupiter.api.Test;
import tree.utils.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Parser.stringToTreeNode("[3,6,19]"), s.getTargetCopy(Parser.stringToTreeNode("[7,4,3,null,null,6,19]"),
                Parser.stringToTreeNode("[7,4,3,null,null,6,19]"), Parser.stringToTreeNode("[3,6,19]")));
    }
}