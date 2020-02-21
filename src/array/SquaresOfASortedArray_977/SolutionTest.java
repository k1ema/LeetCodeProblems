package array.SquaresOfASortedArray_977;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {0, 1, 9, 16, 100}, s.sortedSquares(new int[] {-4, -1, 0, 3, 10}));
        assertArrayEquals(new int[] {0, 9, 25, 36, 100}, s.sortedSquares(new int[] {-6, -5, 0, 3, 10}));
        assertArrayEquals(new int[] {4, 9, 16, 25, 36}, s.sortedSquares(new int[] {-6, -5, -4, -3, -2}));
        assertArrayEquals(new int[] {0, 1, 1, 1}, s.sortedSquares(new int[] {-1, 0, 1, 1}));
        assertArrayEquals(new int[] {0, 1, 16, 16}, s.sortedSquares(new int[] {-1, 0, 4, 4}));
        assertArrayEquals(new int[] {0, 1, 1, 16}, s.sortedSquares(new int[] {-1, -1, 0, 4}));
        assertArrayEquals(new int[] {1, 4, 9, 16, 16, 25, 49, 49, 81, 100},
                s.sortedSquares(new int[] {-9, -7, -5, -3, -1, 2, 4, 4, 7, 10}));
    }
}
