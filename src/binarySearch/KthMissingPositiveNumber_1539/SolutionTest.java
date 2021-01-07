package binarySearch.KthMissingPositiveNumber_1539;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(9, s.findKthPositive(new int[] {2, 3, 4, 7, 11}, 5));
        assertEquals(6, s.findKthPositive(new int[] {1, 2, 3, 4}, 2));
    }
}