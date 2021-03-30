package heap.SlidingWindowMedian_480;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new double[] {1, -1, -1, 3, 5, 6}, s.medianSlidingWindow(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3));
        assertArrayEquals(new double[] {2147483647}, s.medianSlidingWindow(new int[] {2147483647, 2147483647}, 2));
    }
}