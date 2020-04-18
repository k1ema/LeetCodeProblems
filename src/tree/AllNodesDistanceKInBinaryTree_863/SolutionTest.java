package tree.AllNodesDistanceKInBinaryTree_863;

import org.junit.Test;
import tree.utils.Parser;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void testBFS() {
        test(new SolutionBFS());
    }

    @Test
    public void testDFS() {
        test(new SolutionDFS());
    }

    private void test(Solution s) {
        assertEquals(Arrays.asList(7, 4, 1),
                s.distanceK(Parser.stringToTreeNode("[3,5,1,6,2,0,8,null,null,7,4]"),
                        Parser.stringToTreeNode("[5,6,2,null,null,7,4]"), 2));
        assertEquals(Collections.singletonList(1),
                s.distanceK(Parser.stringToTreeNode("[0,1,null,3,2]"), Parser.stringToTreeNode("[2]"), 1));
        assertEquals(Collections.singletonList(2),
                s.distanceK(Parser.stringToTreeNode("[0,null,1,null,2,null,3,null,4]"),
                        Parser.stringToTreeNode("[0,null,1,null,2,null,3,null,4]"), 2));
        assertEquals(Collections.singletonList(5),
                s.distanceK(Parser.stringToTreeNode("[0,1,6,2,3,null,null,7,4,null,null,null,null,null,5]"),
                        Parser.stringToTreeNode("[1,2,3,7,4,null,null,null,null,null,5]"), 3));
    }
}