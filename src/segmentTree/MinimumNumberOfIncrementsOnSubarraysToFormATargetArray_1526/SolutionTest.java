package segmentTree.MinimumNumberOfIncrementsOnSubarraysToFormATargetArray_1526;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.minNumberOperations(new int[] {1, 2, 3, 2, 1}));
        assertEquals(4, s.minNumberOperations(new int[] {3, 1, 1, 2}));
        assertEquals(7, s.minNumberOperations(new int[] {3, 1, 5, 4, 2}));
        assertEquals(1, s.minNumberOperations(new int[] {1, 1, 1, 1}));
    }
}