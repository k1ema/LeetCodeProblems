package dynamic.MinimumPathSum_64;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(7, s.minPathSum(new int[][] {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
        assertEquals(0, s.minPathSum(new int[][] {{}, {}, {}}));
        assertEquals(0, s.minPathSum(new int[][] {{}}));
        assertEquals(0, s.minPathSum(new int[][] {}));
        assertEquals(0, s.minPathSum(null));
    }
}
