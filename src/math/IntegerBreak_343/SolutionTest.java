package math.IntegerBreak_343;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.integerBreak(2));
        assertEquals(2, s.integerBreak(3));
        assertEquals(6, s.integerBreak(5));
        assertEquals(9, s.integerBreak(6));
        assertEquals(12, s.integerBreak(7));
        assertEquals(18, s.integerBreak(8));
        assertEquals(27, s.integerBreak(9));
        assertEquals(36, s.integerBreak(10));
    }
}