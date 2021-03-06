package binarySearch.Sqrt_69;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.mySqrt(4));
        assertEquals(2, s.mySqrt(8));
        assertEquals(4, s.mySqrt(16));
        assertEquals(8, s.mySqrt(64));
        assertEquals(2, s.mySqrt(5));
        assertEquals(1, s.mySqrt(3));
        assertEquals(1, s.mySqrt(1));
        assertEquals(0, s.mySqrt(0));
    }
}
