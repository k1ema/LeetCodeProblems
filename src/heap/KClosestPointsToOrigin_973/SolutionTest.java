package heap.KClosestPointsToOrigin_973;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[][] {{-2, 2}}, s.kClosest(new int[][] {{1, 3}, {-2, 2}}, 1));
        assertArrayEquals(new int[][] {{3, 3}, {-2, 4}}, s.kClosest(new int[][] {{3, 3}, {5, -1}, {-2, 4}}, 2));
        assertArrayEquals(new int[][] {{-2, -6}, {-7, -2}, {2, 8}, {10, 3}, {-8, 1}},
                s.kClosest(new int[][] {{-2, -6}, {-7, -2}, {-9, 6}, {10, 3}, {-8, 1}, {2, 8}}, 5));
    }
}