package binarySearch.SearchInsertPosition_35;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.searchInsert(new int[] {1, 3, 5, 6}, 5));
        assertEquals(1, s.searchInsert(new int[] {1, 3, 5, 6}, 2));
        assertEquals(4, s.searchInsert(new int[] {1, 3, 5, 6}, 7));
        assertEquals(0, s.searchInsert(new int[] {1, 3, 5, 6}, 0));
        assertEquals(3, s.searchInsert(new int[] {1, 3, 5, 8}, 7));
    }
}