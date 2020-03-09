package array.JumpGame_55;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.canJump(new int[] {0}));
        assertTrue(s.canJump(new int[] {1, 0}));
        assertTrue(s.canJump(new int[] {1, 0}));
        assertFalse(s.canJump(new int[] {0, 1}));
        assertTrue(s.canJump(new int[] {2, 3, 1, 1, 4}));
        assertFalse(s.canJump(new int[] {3, 2, 1, 0, 4}));
        assertFalse(s.canJump(new int[] {5, 3, 2, 1, 0, 0, 4}));
        assertTrue(s.canJump(new int[] {6, 3, 2, 1, 0, 0, 4}));
        assertTrue(s.canJump(new int[] {5, 3, 2, 1, 0, 2, 0, 4}));
        assertTrue(s.canJump(new int[] {10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
        assertFalse(s.canJump(new int[] {0, 2, 3}));
    }
}