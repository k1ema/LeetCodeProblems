package stack.LargestRectangleInHistogram_84;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(10, s.largestRectangleArea(new int[] {2, 1, 5, 6, 2, 3}));
        assertEquals(15, s.largestRectangleArea(new int[] {2, 1, 5, 6, 7, 3}));
        assertEquals(24, s.largestRectangleArea(new int[] {2, 1, 5, 6, 2, 3, 8, 8, 8}));
        assertEquals(15, s.largestRectangleArea(new int[] {0, 1, 2, 3, 4, 5, 1, 3, 5, 6, 4, 3}));
    }
}