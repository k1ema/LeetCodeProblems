package tree.AllElementsInTwoBinarySearchTrees_1305;

import org.junit.jupiter.api.Test;
import tree.utils.Parser;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(0, 1, 1, 2, 3, 4),
                s.getAllElements(Parser.stringToTreeNode("[2,1,4]"),
                        Parser.stringToTreeNode("[1,0,3]")));
        assertEquals(Arrays.asList(-10, 0, 0, 1, 2, 5, 7, 10),
                s.getAllElements(Parser.stringToTreeNode("[0,-10,10]"),
                        Parser.stringToTreeNode("[5,1,7,0,2]")));
        assertEquals(Arrays.asList(0, 1, 2, 5, 7),
                s.getAllElements(Parser.stringToTreeNode("[]"),
                        Parser.stringToTreeNode("[5,1,7,0,2]")));
        assertEquals(Arrays.asList(-10, 0, 10),
                s.getAllElements(Parser.stringToTreeNode("[0,-10,10]"),
                        Parser.stringToTreeNode("[]")));
        assertEquals(Arrays.asList(1, 1, 8, 8),
                s.getAllElements(Parser.stringToTreeNode("[1,null,8]"),
                        Parser.stringToTreeNode("[8,1]")));
    }
}