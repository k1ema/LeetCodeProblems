package bitManipulation.PowerOfTwo_231;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.isPowerOfTwo(1));
        assertTrue(s.isPowerOfTwo(16));
        assertTrue(s.isPowerOfTwo(1024));
        assertFalse(s.isPowerOfTwo(216));
    }
}
