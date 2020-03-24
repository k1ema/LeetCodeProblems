package array.ShortestUnsortedContinuousSubarray_581;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(0, s.findUnsortedSubarray(new int[] {1}));
        assertEquals(0, s.findUnsortedSubarray(new int[] {1, 7}));
        assertEquals(2, s.findUnsortedSubarray(new int[] {7, 1}));
        assertEquals(5, s.findUnsortedSubarray(new int[] {2, 6, 4, 8, 10, 9, 15}));
        assertEquals(6, s.findUnsortedSubarray(new int[] {2, 6, 4, 8, 25, 9, 15}));
        assertEquals(4, s.findUnsortedSubarray(new int[] {1, 9, 8, 2, 7, 15}));
    }
}