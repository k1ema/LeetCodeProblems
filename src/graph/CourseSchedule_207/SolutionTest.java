package graph.CourseSchedule_207;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.canFinish(2, new int[][] {{1, 0}}));
        assertTrue(s.canFinish(2, new int[][] {{0, 1}}));
        assertFalse(s.canFinish(2, new int[][] {{1, 0}, {0, 1}}));
        assertTrue(s.canFinish(3, new int[][] {{1, 0}, {2, 1}}));
        assertTrue(s.canFinish(4, new int[][] {{0, 1}, {1, 2}, {2, 3}}));
    }
}
