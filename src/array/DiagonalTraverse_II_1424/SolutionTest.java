package array.DiagonalTraverse_II_1424;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {1, 4, 2, 7, 5, 3, 8, 6, 9},
                s.findDiagonalOrder(Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9))));
        assertArrayEquals(new int[] {1, 6, 2, 8, 7, 3, 9, 4, 12, 10, 5, 13, 11, 14, 15, 16},
                s.findDiagonalOrder(Arrays.asList(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(6, 7), Arrays.asList(8),
                        Arrays.asList(9, 10, 11), Arrays.asList(12, 13, 14, 15, 16))));
        assertArrayEquals(new int[] {1, 4, 2, 5, 3, 8, 6, 9, 7, 10, 11},
                s.findDiagonalOrder(Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4), Arrays.asList(5, 6, 7),
                        Arrays.asList(8), Arrays.asList(9, 10, 11))));
        assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6}, s.findDiagonalOrder(Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6))));
        assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6}, s.findDiagonalOrder(Arrays.asList(Collections.singletonList(1), Collections.singletonList(2),
                Collections.singletonList(3), Collections.singletonList(4), Collections.singletonList(5), Collections.singletonList(6))));
    }
}