package dynamic.PerfectSquares_279;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.numSquares(4));
        assertEquals(2, s.numSquares(5));
        assertEquals(3, s.numSquares(6));
        assertEquals(4, s.numSquares(7));
        assertEquals(2, s.numSquares(8));
        assertEquals(1, s.numSquares(9));
        assertEquals(2, s.numSquares(10));
        assertEquals(3, s.numSquares(11));
        assertEquals(3, s.numSquares(12));
        assertEquals(2, s.numSquares(13));
        assertEquals(3, s.numSquares(14));
        assertEquals(4, s.numSquares(15));
        assertEquals(1, s.numSquares(16));
        assertEquals(3, s.numSquares(48));
    }
}