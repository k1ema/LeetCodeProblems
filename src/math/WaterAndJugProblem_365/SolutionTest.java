package math.WaterAndJugProblem_365;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.canMeasureWater(3, 5, 4));
        assertFalse(s.canMeasureWater(2, 6, 5));
        assertTrue(s.canMeasureWater(34, 5, 6));
    }
}