package unionFind.RedundantConnection_684;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {2, 3}, s.findRedundantConnection(new int[][] {{1, 2}, {1, 3}, {2, 3}}));
        assertArrayEquals(new int[] {1, 4}, s.findRedundantConnection(new int[][] {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}}));
    }
}
