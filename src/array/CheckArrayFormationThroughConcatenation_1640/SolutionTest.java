package array.CheckArrayFormationThroughConcatenation_1640;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.canFormArray(new int[] {85}, new int[][] {{85}}));
        assertTrue(s.canFormArray(new int[] {15, 88}, new int[][] {{88}, {15}}));
        assertFalse(s.canFormArray(new int[] {49, 18, 16}, new int[][] {{16, 18, 49}}));
        assertTrue(s.canFormArray(new int[] {91, 4, 64, 78}, new int[][] {{78}, {4, 64}, {91}}));
        assertFalse(s.canFormArray(new int[] {1, 3, 5, 7}, new int[][] {{2, 4, 6, 8}}));
    }
}