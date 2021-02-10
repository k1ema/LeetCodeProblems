package array.MakeTwoArraysEqualByReversingSubArrays_1460;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.canBeEqual(new int[] {1, 2, 3, 4}, new int[] {2, 4, 1, 3}));
        assertTrue(s.canBeEqual(new int[] {7}, new int[] {7}));
        assertTrue(s.canBeEqual(new int[] {1, 12}, new int[] {12, 1}));
        assertFalse(s.canBeEqual(new int[] {3, 7, 9}, new int[] {3, 7, 11}));
        assertTrue(s.canBeEqual(new int[] {1, 1, 1, 1, 1}, new int[] {1, 1, 1, 1, 1}));
    }
}