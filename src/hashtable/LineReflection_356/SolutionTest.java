package hashtable.LineReflection_356;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.isReflected(new int[][] {{1, 1}, {-1, 1}}));
        assertFalse(s.isReflected(new int[][] {{1, 1}, {-1, -1}}));
        assertFalse(s.isReflected(new int[][] {{0, 0}, {1, 0}, {3, 0}}));
        assertTrue(s.isReflected(new int[][] {{-16, 1}, {16, 1}, {16, 1}}));
    }
}