package graph.CourseSchedule_207;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.canFinish(2, new int[][] {{1, 0}}));
        assertTrue(s.canFinish(2, new int[][] {{0, 1}}));
        assertFalse(s.canFinish(2, new int[][] {{1, 0}, {0, 1}}));
        assertTrue(s.canFinish(3, new int[][] {{1, 0}, {2, 1}}));
        assertTrue(s.canFinish(4, new int[][] {{0, 1}, {1, 2}, {2, 3}}));
        assertFalse(s.canFinish(4, new int[][] {{3, 0}, {0, 1}, {1, 2}, {2, 0}}));
    }
}
