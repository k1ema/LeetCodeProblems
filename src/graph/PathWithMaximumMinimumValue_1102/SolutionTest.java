package graph.PathWithMaximumMinimumValue_1102;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(4, s.maximumMinimumPath(new int[][] {
                {5, 4, 5},
                {1, 2, 6},
                {7, 4, 6},
        }));

        assertEquals(2, s.maximumMinimumPath(new int[][] {
                {2, 2, 1, 2, 2, 2},
                {1, 2, 2, 2, 1, 2},
        }));

        assertEquals(3, s.maximumMinimumPath(new int[][] {
                {3, 4, 6, 3, 4},
                {0, 2, 1, 1, 7},
                {8, 8, 3, 2, 7},
                {3, 2, 4, 9, 8},
                {4, 1, 2, 0, 0},
                {4, 6, 5, 4, 3},
        }));

        assertEquals(2, s.maximumMinimumPath(new int[][] {
                {2, 0, 5, 2, 0},
                {2, 4, 4, 4, 3},
                {1, 5, 0, 0, 0},
                {5, 4, 4, 3, 1},
                {1, 3, 1, 5, 3},
        }));
    }
}