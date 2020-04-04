package math.CircleAndRectangleOverlapping_1401;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.checkOverlap(1, 0, 0, 1, -1, 3,1));
        assertTrue(s.checkOverlap(1, 0, 0, -1, 0, 0,1));
        assertTrue(s.checkOverlap(1, 1, 1, -3, -3, 3,3));
        assertFalse(s.checkOverlap(1, 1, 1, 1, -3, 2,-1));
        assertTrue(s.checkOverlap(1, 1, 1, 1, -3, 2,1));
        assertTrue(s.checkOverlap(4, 102, 50, 0, 0, 100,100));
    }
}