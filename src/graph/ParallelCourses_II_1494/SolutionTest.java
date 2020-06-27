package graph.ParallelCourses_II_1494;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.minNumberOfSemesters(4, new int[][] {{2, 1}, {3, 1}, {1, 4}}, 2));
        assertEquals(4, s.minNumberOfSemesters(5, new int[][] {{2, 1}, {3, 1}, {4, 1}, {1, 5}}, 2));
        assertEquals(6, s.minNumberOfSemesters(11, new int[][] {}, 2));
        assertEquals(1, s.minNumberOfSemesters(2, new int[][] {}, 2));
        assertEquals(2, s.minNumberOfSemesters(3, new int[][] {}, 2));
        assertEquals(4, s.minNumberOfSemesters(4, new int[][] {{1, 2}, {4, 2}}, 1));
        assertEquals(3, s.minNumberOfSemesters(3, new int[][] {{2, 3}, {2, 1}}, 1));
        assertEquals(3, s.minNumberOfSemesters(8, new int[][] {{1, 6}, {2, 7}, {8, 7}, {2, 5}, {3, 4}}, 3));
        assertEquals(6, s.minNumberOfSemesters(6, new int[][] {{2, 5}, {1, 5}, {3, 5}, {3, 4}, {3, 6}}, 1));
        assertEquals(3, s.minNumberOfSemesters(6, new int[][] {{2, 5}, {1, 5}, {3, 5}, {3, 4}, {3, 6}}, 2));
        assertEquals(2, s.minNumberOfSemesters(6, new int[][] {{2, 5}, {1, 5}, {3, 5}, {3, 4}, {3, 6}}, 3));
    }
}
