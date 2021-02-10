package dynamic.CountSubmatricesWithAllOnes_1504;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(13, s.numSubmat(new int[][] {{1, 0, 1}, {1, 1, 0}, {1, 1, 0}}));
        assertEquals(24, s.numSubmat(new int[][] {{0, 1, 1, 0}, {0, 1, 1, 1}, {1, 1, 1, 0}}));
        assertEquals(21, s.numSubmat(new int[][] {{1, 1, 1, 1, 1, 1}}));
        assertEquals(5, s.numSubmat(new int[][] {{1, 0, 1}, {0, 1, 0}, {1, 0, 1}}));
    }
}