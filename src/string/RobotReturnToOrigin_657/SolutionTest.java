package string.RobotReturnToOrigin_657;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.judgeCircle("UD"));
        assertFalse(s.judgeCircle("LL"));
    }
}
