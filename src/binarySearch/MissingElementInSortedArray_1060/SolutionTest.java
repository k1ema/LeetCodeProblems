package binarySearch.MissingElementInSortedArray_1060;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(5, s.missingElement(new int[] {4, 7, 9, 10}, 1));
        assertEquals(8, s.missingElement(new int[] {4, 7, 9, 10}, 3));
        assertEquals(6, s.missingElement(new int[] {1, 2, 4}, 3));
        assertEquals(12, s.missingElement(new int[] {10}, 2));
    }
}