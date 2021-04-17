package mst.SwimInRisingWater_778;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.swimInWater(new int[][] {{0, 2}, {1, 3}}));
        assertEquals(16, s.swimInWater(new int[][] {{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}}));
        assertEquals(3, s.swimInWater(new int[][] {{3, 2}, {0, 1}}));
    }
}