package dynamic.MaximumSumCircularSubarray_918;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.maxSubarraySumCircular(new int[] {1, -2, 3, -2}));
        assertEquals(10, s.maxSubarraySumCircular(new int[] {5, -3, 5}));
        assertEquals(4, s.maxSubarraySumCircular(new int[] {3, -1, 2, -1}));
        assertEquals(3, s.maxSubarraySumCircular(new int[] {3, -2, 2, -3}));
        assertEquals(-1, s.maxSubarraySumCircular(new int[] {-2, -3, -1}));
        assertEquals(19, s.maxSubarraySumCircular(new int[] {2, -2, 2, 7, 8, 0}));
        assertEquals(15, s.maxSubarraySumCircular(new int[] {-2, 4, -5, 4, -5, 9, 4}));
        assertEquals(16, s.maxSubarraySumCircular(new int[] {0, 5, 8, -9, 9, -7, 3, -2}));
    }
}