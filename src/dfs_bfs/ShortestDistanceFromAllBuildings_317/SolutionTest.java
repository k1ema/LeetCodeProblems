package dfs_bfs.ShortestDistanceFromAllBuildings_317;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(7, s.shortestDistance(new int[][] {{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
        assertEquals(-1, s.shortestDistance(new int[][] {{1}}));
        assertEquals(1, s.shortestDistance(new int[][] {{0, 1}}));
        assertEquals(2, s.shortestDistance(new int[][] {{0, 1}, {1, 0}}));
        assertEquals(2, s.shortestDistance(new int[][] {{0, 1}, {1, 0}}));
        assertEquals(-1, s.shortestDistance(new int[][] {{1, 2, 0}}));
        assertEquals(-1, s.shortestDistance(new int[][] {{0, 2, 1}, {1, 0, 2}, {0, 1, 0}}));
        assertEquals(-1, s.shortestDistance(new int[][] {{1, 0, 1, 0, 1}}));
        assertEquals(88, s.shortestDistance(new int[][] {{1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 1}, {0, 1, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 1}, {1, 0, 1, 0, 0, 1}, {1, 0, 0, 0, 0, 1}, {0, 1, 1, 1, 1, 0}}));
    }
}