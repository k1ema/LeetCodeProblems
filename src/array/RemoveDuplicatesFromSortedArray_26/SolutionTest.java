package array.RemoveDuplicatesFromSortedArray_26;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.removeDuplicates(new int[] {1, 1, 2}));
        assertEquals(5, s.removeDuplicates(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
        assertEquals(1, s.removeDuplicates(new int[] {1}));
        assertEquals(5, s.removeDuplicates(new int[] {1, 1, 2, 2, 2, 2, 3, 3, 4, 5}));
    }
}
