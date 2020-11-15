package array.RemoveInterval_1272;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(Arrays.asList(0, 1), Arrays.asList(6, 7)), s.removeInterval(new int[][] {{0, 2}, {3, 4}, {5, 7}}, new int[] {1, 6}));
        assertEquals(Arrays.asList(Arrays.asList(0, 2), Arrays.asList(3, 5)), s.removeInterval(new int[][] {{0, 5}}, new int[] {2, 3}));
        assertEquals(Arrays.asList(Arrays.asList(-5, -4), Arrays.asList(-3, -2), Arrays.asList(4, 5), Arrays.asList(8, 9)),
                s.removeInterval(new int[][] {{-5, -4}, {-3, -2}, {1, 2}, {3, 5}, {8, 9}}, new int[] {-1, 4}));
        assertEquals(Collections.singletonList(Arrays.asList(50, 100)), s.removeInterval(new int[][] {{0, 100}}, new int[] {0, 50}));
    }
}