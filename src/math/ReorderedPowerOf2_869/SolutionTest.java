package math.ReorderedPowerOf2_869;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.reorderedPowerOf2(1));
        assertFalse(s.reorderedPowerOf2(10));
        assertTrue(s.reorderedPowerOf2(16));
        assertFalse(s.reorderedPowerOf2(24));
        assertTrue(s.reorderedPowerOf2(46));
        assertTrue(s.reorderedPowerOf2(2014));
        assertTrue(s.reorderedPowerOf2(6049));
    }
}