package array.SpiralMatrix_II_59;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[][] {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}, s.generateMatrix(3));
    }
}