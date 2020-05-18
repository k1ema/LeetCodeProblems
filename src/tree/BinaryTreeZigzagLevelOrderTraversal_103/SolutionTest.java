package tree.BinaryTreeZigzagLevelOrderTraversal_103;

import org.junit.Test;
import tree.utils.Parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(3));
        res.add(Arrays.asList(20, 9));
        res.add(Arrays.asList(15, 7));
        assertEquals(res, s.zigzagLevelOrder(Parser.stringToTreeNode("[3,9,20,null,null,15,7]")));
    }
}