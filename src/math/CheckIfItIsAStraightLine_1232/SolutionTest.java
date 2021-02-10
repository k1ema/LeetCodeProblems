package math.CheckIfItIsAStraightLine_1232;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.checkStraightLine(new int[][] {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
        assertFalse(s.checkStraightLine(new int[][] {{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}}));
    }
}