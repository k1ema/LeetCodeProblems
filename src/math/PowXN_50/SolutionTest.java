package math.PowXN_50;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1024, s.myPow(2.00000, 10), 0.00001);
        assertEquals(9.26100, s.myPow(2.10000, 3), 0.00001);
        assertEquals(0.25000, s.myPow(2.00000, -2), 0.00001);
        assertEquals(1, s.myPow(1.00000, 2147483647), 0.00001);
        assertEquals(1, s.myPow(0.44528, 0), 0.00001);
        assertEquals(0.00002, s.myPow(8.84372, -5), 0.00001);
        assertEquals(0.5, s.myPow(2, -1), 0.00001);
        assertEquals(0.00000, s.myPow(0.00001, 2147483647), 0.00001);
    }
}