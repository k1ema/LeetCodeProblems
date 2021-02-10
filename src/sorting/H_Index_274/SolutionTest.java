package sorting.H_Index_274;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.hIndex(new int[] {3, 0, 6, 1, 5}));
        assertEquals(2, s.hIndex(new int[] {2, 0, 6, 1, 5}));
        assertEquals(3, s.hIndex(new int[] {4, 0, 6, 1, 5}));
        assertEquals(4, s.hIndex(new int[] {5, 3, 10, 4, 8}));
        assertEquals(1, s.hIndex(new int[] {100}));
        assertEquals(1, s.hIndex(new int[] {1}));
        assertEquals(0, s.hIndex(new int[] {}));
        assertEquals(0, s.hIndex(new int[] {0}));
        assertEquals(2, s.hIndex(new int[] {11, 15}));
    }
}