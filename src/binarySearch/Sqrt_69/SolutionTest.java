package binarySearch.Sqrt_69;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.mySqrt(4));
        assertEquals(2, s.mySqrt(8));
        assertEquals(4, s.mySqrt(16));
        assertEquals(8, s.mySqrt(64));
    }
}
