package sorting.H_Index_274;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.hIndex(new int[] {3, 0, 6, 1, 5}));
        assertEquals(2, s.hIndex(new int[] {2, 0, 6, 1, 5}));
        assertEquals(3, s.hIndex(new int[] {4, 0, 6, 1, 5}));
        assertEquals(4, s.hIndex(new int[] {5, 3, 10, 4, 8}));
    }
}