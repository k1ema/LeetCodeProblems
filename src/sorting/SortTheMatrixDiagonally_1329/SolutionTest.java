package sorting.SortTheMatrixDiagonally_1329;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[][] {{1, 1, 1, 1}, {1, 2, 2, 2}, {1, 2, 3, 3}},
                s.diagonalSort(new int[][] {{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}}));
    }
}