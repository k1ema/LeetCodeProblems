package binarySearch.ValidPerfectSquare_367;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.isPerfectSquare(16));
        assertFalse(s.isPerfectSquare(14));
        assertTrue(s.isPerfectSquare(808201)); // 899 * 899
    }
}