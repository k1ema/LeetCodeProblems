package graph.MinimumNumberOfVerticesToReachAllNodes_1557;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(0, 3), s.findSmallestSetOfVertices(6,
                Arrays.asList(Arrays.asList(0, 1), Arrays.asList(0, 2), Arrays.asList(2, 5),
                        Arrays.asList(3, 4), Arrays.asList(4, 2))));
        assertEquals(Arrays.asList(0, 2, 3), s.findSmallestSetOfVertices(5,
                Arrays.asList(Arrays.asList(0, 1), Arrays.asList(2, 1), Arrays.asList(3, 1),
                        Arrays.asList(1, 4), Arrays.asList(2, 4))));
    }
}