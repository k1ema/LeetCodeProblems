package bitManipulation.PowerOfFour_342;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.isPowerOfFour(1));
        assertFalse(s.isPowerOfFour(2));
        assertTrue(s.isPowerOfFour(4));
        assertFalse(s.isPowerOfFour(5));
        assertTrue(s.isPowerOfFour(16));
        assertTrue(s.isPowerOfFour(256));
        assertTrue(s.isPowerOfFour(16777216));
        assertFalse(s.isPowerOfFour(177146));
        assertFalse(s.isPowerOfFour(45));
        assertFalse(s.isPowerOfFour(-16));
        assertFalse(s.isPowerOfFour(0));
    }
}
