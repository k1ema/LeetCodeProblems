package math.TheKthFactorOfN_1492;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.kthFactor(12, 3));
        assertEquals(7, s.kthFactor(7, 2));
        assertEquals(-1, s.kthFactor(4, 4));
        assertEquals(1, s.kthFactor(1, 1));
        assertEquals(4, s.kthFactor(1000, 3));
    }
}