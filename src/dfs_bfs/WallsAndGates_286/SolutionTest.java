package dfs_bfs.WallsAndGates_286;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        int[][] rooms = new int[][] {{2147483647, -1, 0, 2147483647}, {2147483647, 2147483647, 2147483647, -1}, {2147483647, -1, 2147483647, -1}, {0, -1, 2147483647, 2147483647}};
        s.wallsAndGates(rooms);
        assertArrayEquals(new int[][] {{3, -1, 0, 1}, {2, 2, 1, -1}, {1, -1, 2, -1}, {0, -1, 3, 4}}, rooms);

        rooms = new int[][] {{-1}};
        s.wallsAndGates(rooms);
        assertArrayEquals(new int[][] {{-1}}, rooms);

        rooms = new int[][] {{2147483647}};
        s.wallsAndGates(rooms);
        assertArrayEquals(new int[][] {{2147483647}}, rooms);

        rooms = new int[][] {{0}};
        s.wallsAndGates(rooms);
        assertArrayEquals(new int[][] {{0}}, rooms);
    }
}