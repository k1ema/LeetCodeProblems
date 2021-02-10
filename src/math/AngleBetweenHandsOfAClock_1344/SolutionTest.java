package math.AngleBetweenHandsOfAClock_1344;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(165, s.angleClock(12, 30), 0.00001);
        assertEquals(75, s.angleClock(3, 30), 0.00001);
        assertEquals(7.5, s.angleClock(3, 15), 0.00001);
        assertEquals(155, s.angleClock(4, 50), 0.00001);
        assertEquals(0, s.angleClock(12, 0), 0.00001);
    }
}