package binarySearch.BinarySearch_704;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(4, s.search(new int[] {-1, 0, 3, 5, 9, 12}, 9));
        assertEquals(-1, s.search(new int[] {-1, 0, 3, 5, 9, 12}, 2));
    }
}