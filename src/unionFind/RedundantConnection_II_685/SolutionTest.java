package unionFind.RedundantConnection_II_685;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {2, 3},
                s.findRedundantDirectedConnection(new int[][] {{1, 2}, {1, 3}, {2, 3}}));
        assertArrayEquals(new int[] {4, 1},
                s.findRedundantDirectedConnection(new int[][] {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}}));
        assertArrayEquals(new int[] {2, 1},
                s.findRedundantDirectedConnection(new int[][] {{2, 1}, {1, 4}, {4, 2}, {3, 1}}));
    }
}
