package binarySearch.KokoEatingBananas_875;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(4, s.minEatingSpeed(new int[] {3, 6, 7, 11}, 8));
        assertEquals(30, s.minEatingSpeed(new int[] {30, 11, 23, 4, 20}, 5));
        assertEquals(23, s.minEatingSpeed(new int[] {30, 11, 23, 4, 20}, 6));
        assertEquals(1, s.minEatingSpeed(new int[] {5}, 6));
        assertEquals(3, s.minEatingSpeed(new int[] {5, 5}, 4));
    }
}