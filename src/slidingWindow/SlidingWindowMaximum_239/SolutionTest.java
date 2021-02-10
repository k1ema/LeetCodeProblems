package slidingWindow.SlidingWindowMaximum_239;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {3, 3, 5, 5, 6, 7}, s.maxSlidingWindow(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3));
        assertArrayEquals(new int[] {1}, s.maxSlidingWindow(new int[] {1}, 1));
        assertArrayEquals(new int[] {1, -1}, s.maxSlidingWindow(new int[] {1, -1}, 1));
        assertArrayEquals(new int[] {11}, s.maxSlidingWindow(new int[] {9, 11}, 2));
        assertArrayEquals(new int[] {4}, s.maxSlidingWindow(new int[] {4, -2}, 2));
        assertArrayEquals(new int[] {10, 9, 8, 7, 6, 5}, s.maxSlidingWindow(new int[] {10, 9, 8, 7, 6, 5, 4}, 2));
        assertArrayEquals(new int[] {10, 9, 8, 7, 6}, s.maxSlidingWindow(new int[] {10, 9, 8, 7, 6, 5, 4}, 3));
    }
}