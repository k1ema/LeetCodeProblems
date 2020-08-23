package greedy.MinimumNumbersOfFunctionCallsToMakeTargetArray_1558;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(5, s.minOperations(new int[] {1, 5}));
        assertEquals(3, s.minOperations(new int[] {2, 2}));
        assertEquals(3, s.minOperations(new int[] {2, 2}));
        assertEquals(6, s.minOperations(new int[] {4, 2, 5}));
        assertEquals(7, s.minOperations(new int[] {3, 2, 2, 4}));
        assertEquals(8, s.minOperations(new int[] {2, 4, 8, 16}));
    }
}