package binarySearch.H_Index_II_275;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.hIndex(new int[] {0, 1, 3, 5, 6}));
        assertEquals(2, s.hIndex(new int[] {0, 1, 2, 5, 6}));
        assertEquals(3, s.hIndex(new int[] {0, 1, 4, 5, 6}));
        assertEquals(4, s.hIndex(new int[] {3, 4, 5, 8, 10}));
    }
}