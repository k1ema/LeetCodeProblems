package greedy.CarPooling_1094;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertFalse(s.carPooling(new int[][] {{2, 1, 5}, {3, 3, 7}}, 4));
        assertTrue(s.carPooling(new int[][] {{2, 1, 5}, {3, 3, 7}}, 5));
        assertTrue(s.carPooling(new int[][] {{2, 1, 5}, {3, 5, 7}}, 3));
        assertTrue(s.carPooling(new int[][] {{3, 2, 7}, {3, 7, 9}, {8, 3, 9}}, 11));
    }
}