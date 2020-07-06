package math.UglyNumber_263;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.isUgly(6));
        assertTrue(s.isUgly(8));
        assertFalse(s.isUgly(14));
    }
}