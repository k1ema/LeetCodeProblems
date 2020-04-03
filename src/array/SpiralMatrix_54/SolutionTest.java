package array.SpiralMatrix_54;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5), s.spiralOrder(new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        }));
        assertEquals(Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7), s.spiralOrder(new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
        }));
        assertEquals(Arrays.asList(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10),
                s.spiralOrder(new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        }));
        assertEquals(Arrays.asList(1, 2, 3, 4), s.spiralOrder(new int[][] {
                {1, 2, 3, 4}
        }));
        assertEquals(Arrays.asList(1, 2, 3, 4), s.spiralOrder(new int[][] {
                {1},
                {2},
                {3},
                {4}
        }));
    }
}