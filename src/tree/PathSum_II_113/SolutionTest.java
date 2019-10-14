package tree.PathSum_II_113;

import org.junit.Test;
import tree.utils.Parser;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(
                Arrays.asList(5, 4, 11, 2),
                Arrays.asList(5, 8, 4, 5)
                ),
                s.pathSum(Parser.stringToTreeNode("[5,4,8,11,null,13,4,7,2,null,null,5,1]"), 22));
    }
}
