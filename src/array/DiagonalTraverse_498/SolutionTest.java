package array.DiagonalTraverse_498;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {1, 2, 4, 7, 5, 3, 6, 8, 9}, s.findDiagonalOrder(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6}, s.findDiagonalOrder(new int[][] {{1, 2, 3, 4, 5, 6}}));
        assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6}, s.findDiagonalOrder(new int[][] {{1}, {2}, {3}, {4}, {5}, {6}}));
        assertArrayEquals(new int[] {1}, s.findDiagonalOrder(new int[][] {{1}}));
        assertArrayEquals(new int[] {}, s.findDiagonalOrder(new int[][] {{}}));
    }
}