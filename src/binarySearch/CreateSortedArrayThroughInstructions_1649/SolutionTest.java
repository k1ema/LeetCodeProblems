package binarySearch.CreateSortedArrayThroughInstructions_1649;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.createSortedArray(new int[] {1, 5, 6, 2}));
        assertEquals(3, s.createSortedArray(new int[] {1, 2, 3, 6, 5, 4}));
        assertEquals(4, s.createSortedArray(new int[] {1, 3, 3, 3, 2, 4, 2, 1, 2}));
    }
}