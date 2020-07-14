package array.MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves_1509;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(0, s.minDifference(new int[] {5, 3, 2, 4}));
        assertEquals(1, s.minDifference(new int[] {1, 5, 0, 10, 14}));
        assertEquals(2, s.minDifference(new int[] {6, 6, 0, 1, 1, 4, 6}));
        assertEquals(1, s.minDifference(new int[] {1, 5, 6, 14, 15}));
        assertEquals(1, s.minDifference(new int[] {82, 81, 95, 75, 20}));
    }
}