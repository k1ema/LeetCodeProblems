package mst.ConnectingCitiesWithMinimumCost_1135;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(6, s.minimumCost(3, new int[][] {{1, 2, 5}, {1, 3, 6}, {2, 3, 1}}));
        assertEquals(-1, s.minimumCost(4, new int[][] {{1, 2, 3}, {3, 4, 4}}));
    }
}