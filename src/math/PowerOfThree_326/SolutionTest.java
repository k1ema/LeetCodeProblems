package math.PowerOfThree_326;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.isPowerOfThree(9));
        assertTrue(s.isPowerOfThree(243));
        assertTrue(s.isPowerOfThree(1162261467));
        assertFalse(s.isPowerOfThree(177146));
        assertFalse(s.isPowerOfThree(45));
        assertFalse(s.isPowerOfThree(-27));
        assertFalse(s.isPowerOfThree(0));
    }
}
