package dynamic.CherryPickup_II_1463;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(24, s.cherryPickup(new int[][] {{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}}));
        assertEquals(28, s.cherryPickup(new int[][] {{1, 0, 0, 0, 0, 0, 1}, {2, 0, 0, 0, 0, 3, 0}, {2, 0, 9, 0, 0, 0, 0},
                {0, 3, 0, 5, 4, 0, 0}, {1, 0, 2, 3, 0, 0, 6}}));
        assertEquals(22, s.cherryPickup(new int[][] {{1, 0, 0, 3}, {0, 0, 0, 3}, {0, 0, 3, 3}, {9, 0, 3, 3}}));
        assertEquals(4, s.cherryPickup(new int[][] {{1, 1}, {1, 1}}));
    }
}