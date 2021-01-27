package dfs_bfs.PathWithMinimumEffort_1631;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.minimumEffortPath(new int[][] {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        }));
        assertEquals(1, s.minimumEffortPath(new int[][] {
                {1, 2, 3},
                {3, 8, 4},
                {5, 3, 5}
        }));
        assertEquals(0, s.minimumEffortPath(new int[][] {
                {1, 2, 1, 1, 1},
                {1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1},
                {1, 1, 1, 2, 1},
        }));
        assertEquals(5, s.minimumEffortPath(new int[][] {
                {4, 3, 4, 10, 5, 5, 9, 2},
                {10, 8, 2, 10, 9, 7, 5, 6},
                {5, 8, 10, 10, 10, 7, 4, 2},
                {5, 1, 3, 1, 1, 3, 1, 9},
                {6, 4, 10, 6, 10, 9, 4, 6}
        }));
        assertEquals(6, s.minimumEffortPath(new int[][] {
                {10, 8},
                {10, 8},
                {1, 2},
                {10, 3},
                {1, 3},
                {6, 3},
                {5, 2}
        }));
    }
}

