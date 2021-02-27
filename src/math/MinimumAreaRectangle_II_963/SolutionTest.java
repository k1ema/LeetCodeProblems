package math.MinimumAreaRectangle_II_963;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertDoubleEquals(2d, s.minAreaFreeRect(new int[][] {{1, 2}, {2, 1}, {1, 0}, {0, 1}}));
        assertDoubleEquals(1d, s.minAreaFreeRect(new int[][] {{0, 1}, {2, 1}, {1, 1}, {1, 0}, {2, 0}}));
        assertDoubleEquals(0d, s.minAreaFreeRect(new int[][] {{0, 3}, {1, 2}, {3, 1}, {1, 3}, {2, 1}}));
        assertDoubleEquals(2d, s.minAreaFreeRect(new int[][] {{3, 1}, {1, 1}, {0, 1}, {2, 1}, {3, 3}, {3, 2}, {0, 2}, {2, 3}}));
        assertDoubleEquals(0d, s.minAreaFreeRect(new int[][] {{0, 2}, {0, 1}, {3, 3}, {1, 0}, {2, 3}, {1, 2}, {1, 3}}));
    }

    private void assertDoubleEquals(double expected, double actual) {
        assertTrue(Math.abs(expected - actual) <= 0.00001d);
    }
}