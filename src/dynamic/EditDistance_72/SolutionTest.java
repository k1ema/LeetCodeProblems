package dynamic.EditDistance_72;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.minDistance("horse", "ros"));
        assertEquals(5, s.minDistance("intention", "execution"));
    }
}