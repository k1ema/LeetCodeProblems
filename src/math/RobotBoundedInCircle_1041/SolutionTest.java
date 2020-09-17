package math.RobotBoundedInCircle_1041;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.isRobotBounded("GGLLGG"));
        assertFalse(s.isRobotBounded("GG"));
        assertTrue(s.isRobotBounded("GL"));
    }
}