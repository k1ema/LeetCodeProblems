package binarySearch.BinarySearch_704;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(4, s.search(new int[] {-1, 0, 3, 5, 9, 12}, 9));
        assertEquals(-1, s.search(new int[] {-1, 0, 3, 5, 9, 12}, 2));
        assertEquals(2, s.search(new int[] {-1, 0, 3, 3, 3, 5, 9, 12}, 3));
        assertEquals(7, s.search(new int[] {-1, 0, 3, 3, 3, 5, 9, 12}, 12));
        assertEquals(-1, s.search(new int[] {-1, 0, 3, 3, 3, 5, 9, 12}, -5));
        assertEquals(-1, s.search(new int[] {-1, 0, 3, 3, 3, 5, 9, 12}, 13));
        assertEquals(-1, s.search(new int[] {1}, 0));
        assertEquals(-1, s.search(new int[] {1}, 2));
    }
}