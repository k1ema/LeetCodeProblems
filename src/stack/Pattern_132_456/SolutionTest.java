package stack.Pattern_132_456;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertFalse(s.find132pattern(new int[] {1, 2, 3, 4}));
        assertTrue(s.find132pattern(new int[] {3, 1, 4, 2}));
        assertTrue(s.find132pattern(new int[] {-1, 3, 2, 0}));
        assertTrue(s.find132pattern(new int[] {3, 5, 0, 3, 4}));
    }
}