package binarySearch.FindKthSmallestPairDistance_719;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.smallestDistancePair(new int[] {1, 3, 1}, 2));
        assertEquals(2, s.smallestDistancePair(new int[] {1, 2, 3, 4}, 5));
    }
}