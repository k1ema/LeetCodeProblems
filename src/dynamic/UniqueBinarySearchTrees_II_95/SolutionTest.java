package dynamic.UniqueBinarySearchTrees_II_95;

import org.junit.jupiter.api.Test;
import tree.utils.Parser;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(
                Parser.stringToTreeNode("[1,null,2,null,3]"),
                Parser.stringToTreeNode("[1,null,3,2]"),
                Parser.stringToTreeNode("[2,1,3]"),
                Parser.stringToTreeNode("[3,1,null,null,2]"),
                Parser.stringToTreeNode("[3,2,null,1]")
        ), s.generateTrees(3));
        assertEquals(Collections.emptyList(), s.generateTrees(0));
    }
}
