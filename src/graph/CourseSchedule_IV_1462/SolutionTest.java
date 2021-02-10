package graph.CourseSchedule_IV_1462;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(false, true), s.checkIfPrerequisite(2, new int[][] {{1, 0}}, new int[][] {{0, 1}, {1, 0}}));
        assertEquals(Arrays.asList(false, false), s.checkIfPrerequisite(2, new int[][] {}, new int[][] {{0, 1}, {1, 0}}));
        assertEquals(Arrays.asList(true, true), s.checkIfPrerequisite(3, new int[][] {{1, 2}, {1, 0}, {2, 0}}, new int[][] {{1, 0}, {1, 2}}));
        assertEquals(Arrays.asList(false, true), s.checkIfPrerequisite(3, new int[][] {{1, 0}, {2, 0}}, new int[][] {{0, 1}, {2, 0}}));
        assertEquals(Arrays.asList(true, false, true, false), s.checkIfPrerequisite(5, new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 4}},
                new int[][] {{0, 4}, {4, 0}, {1, 3}, {3, 0}}));
    }
}