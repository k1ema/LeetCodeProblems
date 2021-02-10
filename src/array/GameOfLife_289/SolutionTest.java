package array.GameOfLife_289;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        int[][] actual = new int[][] {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        int[][] expected = new int[][] {{0, 0, 0}, {1, 0, 1}, {0, 1, 1}, {0, 1, 0}};
        s.gameOfLife(actual);
        assertArrayEquals(expected, actual);

        actual = new int[][] {{1, 1}, {1, 0}};
        expected = new int[][] {{1, 1}, {1, 1}};
        s.gameOfLife(actual);
        assertArrayEquals(expected, actual);
    }
}