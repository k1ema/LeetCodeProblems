package array.RangeSumOfSortedSubarraySums_1508;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(13, s.rangeSum(new int[] {1, 2, 3, 4}, 4, 1, 5));
        assertEquals(6, s.rangeSum(new int[] {1, 2, 3, 4}, 4, 3, 4));
        assertEquals(50, s.rangeSum(new int[] {1, 2, 3, 4}, 4, 1, 10));
    }
}