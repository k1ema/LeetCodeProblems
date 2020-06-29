package backtracking.UniquePaths_III_980;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.uniquePathsIII(new int[][] {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1},
        }));
        assertEquals(4, s.uniquePathsIII(new int[][] {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 2},
        }));
        assertEquals(0, s.uniquePathsIII(new int[][] {
                {0, 1},
                {2, 0},
        }));
    }
}