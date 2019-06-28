package graph.Course_Schedule_II_210;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();

        assertArrayEquals(new int[] {0, 1}, s.findOrder(2, new int[][] {{1, 0}}));
        assertArrayEquals(new int[] {1, 0}, s.findOrder(2, new int[][] {{0, 1}}));
        assertArrayEquals(new int[] {}, s.findOrder(2, new int[][] {{0, 1}, {1, 0}}));

        int[] actual = s.findOrder(4, new int[][] {{1, 0}, {2, 0}, {3, 1}, {3, 2}});
        System.out.println(Arrays.toString(actual));
        int[] expected1 = new int[] {0, 1, 2, 3};
        int[] expected2 = new int[] {0, 2, 1, 3};
        assertTrue(Arrays.equals(actual, expected1) || Arrays.equals(actual, expected2));

        assertArrayEquals(new int[] {0}, s.findOrder(1, new int[][] {{}}));
    }
}
