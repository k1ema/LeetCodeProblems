package array.InsertInterval_57;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[][] {{1, 5}, {6, 9}},
                s.insert(new int[][] {{1, 3}, {6, 9}}, new int[] {2, 5}));
        assertArrayEquals(new int[][] {{1, 2}, {3, 10}, {12, 16}},
                s.insert(new int[][] {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[] {4, 8}));
        assertArrayEquals(new int[][] {{1, 2}, {3, 4}, {5, 6}, {10, 16}},
                s.insert(new int[][] {{1, 2}, {5, 6}, {10, 16}}, new int[] {3, 4}));
        assertArrayEquals(new int[][] {{1, 2}, {3, 6}, {10, 16}},
                s.insert(new int[][] {{1, 2}, {4, 6}, {10, 16}}, new int[] {3, 5}));
        assertArrayEquals(new int[][] {{1, 2}, {3, 16}}, s.insert(new int[][] {{1, 2}, {4, 6}, {10, 16}}, new int[] {3, 15}));
        assertArrayEquals(new int[][] {{1, 2}, {3, 18}}, s.insert(new int[][] {{1, 2}, {4, 6}, {10, 16}}, new int[] {3, 18}));
        assertArrayEquals(new int[][] {{1, 5}, {6, 8}}, s.insert(new int[][] {{1, 5}}, new int[] {6, 8}));
        assertArrayEquals(new int[][] {{1, 7}}, s.insert(new int[][] {{1, 5}}, new int[] {5, 7}));
        assertArrayEquals(new int[][] {{0,0}, {1, 5}}, s.insert(new int[][] {{1, 5}}, new int[] {0, 0}));
    }
}