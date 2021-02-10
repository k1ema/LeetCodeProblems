package greedy.MinimumNumberOfArrowsToBurstBalloons_452;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.findMinArrowShots(new int[][] {{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
        assertEquals(4, s.findMinArrowShots(new int[][] {{1, 2}, {3, 4}, {5, 6}, {7, 8}}));
        assertEquals(2, s.findMinArrowShots(new int[][] {{1, 2}, {2, 3}, {3, 4}, {4, 5}}));
        assertEquals(1, s.findMinArrowShots(new int[][] {{1, 2}}));
        assertEquals(1, s.findMinArrowShots(new int[][] {{2, 3}, {2, 3}}));
        assertEquals(2, s.findMinArrowShots(new int[][] {{-2147483646, -2147483645}, {2147483646, 2147483647}}));
    }
}