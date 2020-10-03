package hashtable.KDiffPairsInAnArray_532;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.findPairs(new int[] {3, 1, 4, 1, 5}, 2));
        assertEquals(4, s.findPairs(new int[] {1, 2, 3, 4, 5}, 1));
        assertEquals(1, s.findPairs(new int[] {1, 3, 1, 5, 4}, 0));
        assertEquals(2, s.findPairs(new int[] {1, 2, 4, 4, 3, 3, 0, 9, 2, 3}, 3));
        assertEquals(2, s.findPairs(new int[] {-1, -2, -3}, 1));
    }
}