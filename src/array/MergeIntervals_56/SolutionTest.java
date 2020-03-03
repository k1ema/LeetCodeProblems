package array.MergeIntervals_56;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[][] {{1, 6}, {8, 10}, {15, 18}},
                s.merge(new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}}));
        assertArrayEquals(new int[][] {{1, 4}}, s.merge(new int[][] {{1, 4}, {2, 4}, {3, 4}}));
        assertArrayEquals(new int[][] {{1, 5}}, s.merge(new int[][] {{1, 4}, {4, 5}}));
    }
}