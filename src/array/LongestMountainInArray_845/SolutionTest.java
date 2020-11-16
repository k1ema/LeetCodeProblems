package array.LongestMountainInArray_845;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(5, s.longestMountain(new int[] {2, 1, 4, 7, 3, 2, 5}));
        assertEquals(0, s.longestMountain(new int[] {2, 2, 2}));
        assertEquals(3, s.longestMountain(new int[] {1, 2, 0, 2, 0, 2}));
        assertEquals(0, s.longestMountain(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
        assertEquals(4, s.longestMountain(new int[] {875, 884, 239, 731, 723, 685}));
    }
}