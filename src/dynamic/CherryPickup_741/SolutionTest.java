package dynamic.CherryPickup_741;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(5, s.cherryPickup(new int[][] {{0, 1, -1}, {1, 0, -1}, {1, 1, 1}}));
        assertEquals(0, s.cherryPickup(new int[][] {{1, 1, -1}, {1, -1, 1}, {-1, 1, 1}}));
    }
}