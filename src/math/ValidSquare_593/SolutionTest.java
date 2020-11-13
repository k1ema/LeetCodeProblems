package math.ValidSquare_593;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.validSquare(new int[] {0, 0}, new int[] {1, 1}, new int[] {1, 0}, new int[] {0, 1}));
        assertFalse(s.validSquare(new int[] {1, 1}, new int[] {5, 3}, new int[] {3, 5}, new int[] {7, 7}));
        assertFalse(s.validSquare(new int[] {0, 0}, new int[] {0, 0}, new int[] {0, 0}, new int[] {0, 0}));
        assertFalse(s.validSquare(new int[] {0, 0}, new int[] {1, 1}, new int[] {0, 0}, new int[] {1, 1}));
    }
}