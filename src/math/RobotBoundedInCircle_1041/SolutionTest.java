package math.RobotBoundedInCircle_1041;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.isRobotBounded("GGLLGG"));
        assertFalse(s.isRobotBounded("GG"));
        assertTrue(s.isRobotBounded("GL"));
    }
}