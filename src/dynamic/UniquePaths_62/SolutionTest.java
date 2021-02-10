package dynamic.UniquePaths_62;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.uniquePaths(3, 2));
        assertEquals(28, s.uniquePaths(7, 3));
        assertEquals(1, s.uniquePaths(1, 2));
        assertEquals(1, s.uniquePaths(1, 1));
        assertEquals(15, s.uniquePaths(5, 3));
        assertEquals(193536720, s.uniquePaths(23, 12));
        assertEquals(1916797311, s.uniquePaths(51, 9));
    }
}
