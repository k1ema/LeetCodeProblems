package binarySearch.FindTheSmallestDivisorGivenAThreshold_1283;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(5, s.smallestDivisor(new int[] {1, 2, 5, 9}, 6));
        assertEquals(3, s.smallestDivisor(new int[] {2, 3, 5, 7, 11}, 11));
        assertEquals(4, s.smallestDivisor(new int[] {19}, 5));
        assertEquals(82, s.smallestDivisor(new int[] {1, 2, 5, 9, 10, 123, 737, 15}, 17));
    }
}