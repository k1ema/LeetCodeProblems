package tree.BinaryTreePaths_257;

import org.junit.jupiter.api.Test;
import tree.utils.Parser;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertThat(s.binaryTreePaths(Parser.stringToTreeNode("[1,2,3,null,5]"))).hasSameElementsAs(List.of("1->3", "1->2->5"));
        assertEquals(List.of("1"), s.binaryTreePaths(Parser.stringToTreeNode("[1]")));
    }
}