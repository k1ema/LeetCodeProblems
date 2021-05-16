package dynamic.LongestLineOfConsecutiveOneInMatrix_562;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.longestLine(new int[][] {{0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 1}}));
        assertEquals(4, s.longestLine(new int[][] {{1, 1, 1, 1}, {0, 1, 1, 0}, {0, 0, 0, 1}}));
    }
}