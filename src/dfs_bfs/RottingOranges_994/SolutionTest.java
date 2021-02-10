package dfs_bfs.RottingOranges_994;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(4, s.orangesRotting(new int[][] {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        assertEquals(-1, s.orangesRotting(new int[][] {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
        assertEquals(0, s.orangesRotting(new int[][] {{0, 2}}));
    }
}