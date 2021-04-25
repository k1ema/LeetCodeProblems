package graph.FlowerPlantingWithNoAdjacent_1042;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {1, 2, 3}, s.gardenNoAdj(3, new int[][] {{1, 2}, {2, 3}, {3, 1}}));
        assertArrayEquals(new int[] {1, 2, 1, 2}, s.gardenNoAdj(4, new int[][] {{1, 2}, {3, 4}}));
        assertArrayEquals(new int[] {1, 2, 3, 4}, s.gardenNoAdj(4, new int[][] {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 3}, {2, 4}}));
        assertArrayEquals(new int[] {1, 1, 2, 3}, s.gardenNoAdj(4, new int[][] {{3, 4}, {4, 2}, {3, 2}, {1, 3}}));
        assertArrayEquals(new int[] {1, 1, 2, 3, 2}, s.gardenNoAdj(5, new int[][] {{3, 4}, {4, 5}, {3, 2}, {5, 1}, {1, 3}, {4, 2}}));
    }
}