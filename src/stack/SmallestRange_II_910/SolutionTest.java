package stack.SmallestRange_II_910;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(0, s.smallestRangeII(new int[] {1}, 0));
        assertEquals(6, s.smallestRangeII(new int[] {0, 10}, 2));
        assertEquals(3, s.smallestRangeII(new int[] {1, 3, 6}, 3));
        assertEquals(3, s.smallestRangeII(new int[] {4, 1, 8, 10}, 3));
        assertEquals(3, s.smallestRangeII(new int[] {1, 4, 6, 4}, 3));
        assertEquals(5, s.smallestRangeII(new int[] {7, 8, 8, 5, 2}, 4));
        assertEquals(5, s.smallestRangeII(new int[] {9, 10, 5, 9}, 5));
    }
}