package graph.FloodFill_733;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[][] {{2, 2, 2}, {2, 2, 0}, {2, 0, 1}},
                s.floodFill(new int[][] {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2));
        assertArrayEquals(new int[][] {{0, 0, 0}, {0, 1, 1}},
                s.floodFill(new int[][] {{0, 0, 0}, {0, 1, 1}}, 1, 1, 1));
    }
}