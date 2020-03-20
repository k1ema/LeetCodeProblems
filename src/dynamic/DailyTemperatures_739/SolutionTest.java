package dynamic.DailyTemperatures_739;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        int[] actual = s.dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73});
        int[] expected = new int[] {1, 1, 4, 2, 1, 1, 0, 0};
        assertArrayEquals(expected, actual);

        actual = s.dailyTemperatures(new int[] {89, 62, 70, 58, 47, 47, 46, 76, 100, 70});
        expected = new int[] {8, 1, 5, 4, 3, 2, 1, 1, 0, 0};
        assertArrayEquals(expected, actual);

        actual = s.dailyTemperatures(new int[] {55, 38, 53, 81, 61, 93, 97, 32, 43, 78});
        expected = new int[] {3, 1, 1, 2, 1, 1, 0, 1, 1, 0};
        assertArrayEquals(expected, actual);

        actual = s.dailyTemperatures(new int[] {55, 54, 53, 52, 51, 50, 42, 30});
        expected = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(expected, actual);
    }
}