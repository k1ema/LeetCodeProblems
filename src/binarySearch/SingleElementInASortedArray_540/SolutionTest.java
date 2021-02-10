package binarySearch.SingleElementInASortedArray_540;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.singleNonDuplicate(new int[] {1, 1, 2, 3, 3, 4, 4, 8, 8}));
        assertEquals(10, s.singleNonDuplicate(new int[] {3, 3, 7, 7, 10, 11, 11}));
        assertEquals(1, s.singleNonDuplicate(new int[] {1}));
        assertEquals(2, s.singleNonDuplicate(new int[] {1, 1, 2}));
        assertEquals(1, s.singleNonDuplicate(new int[] {1, 2, 2}));
        assertEquals(8, s.singleNonDuplicate(new int[] {7, 7, 8, 9, 9}));
        assertEquals(3, s.singleNonDuplicate(new int[] {1, 1, 2, 2, 3}));
        assertEquals(1, s.singleNonDuplicate(new int[] {1, 2, 2, 3, 3}));
    }
}