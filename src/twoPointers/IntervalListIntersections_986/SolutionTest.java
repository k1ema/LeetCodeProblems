package twoPointers.IntervalListIntersections_986;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[][] {{1, 2}, {5, 5}, {8, 10}, {15, 23}, {24, 24}, {25, 25}},
                s.intervalIntersection(new int[][] {{0, 2}, {5, 10}, {13, 23}, {24, 25}}, new int[][] {{1, 5}, {8, 12}, {15, 24}, {25, 26}}));
    }
}