package math.FactorialTrailingZeroes_172;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(0, s.trailingZeroes(0));
        assertEquals(0, s.trailingZeroes(3));
        assertEquals(1, s.trailingZeroes(5));
        assertEquals(1, s.trailingZeroes(7));
        assertEquals(2, s.trailingZeroes(10));
        assertEquals(2, s.trailingZeroes(13));
        assertEquals(4, s.trailingZeroes(20));
        assertEquals(7, s.trailingZeroes(30));
        assertEquals(24, s.trailingZeroes(100));
        assertEquals(1151, s.trailingZeroes(4617));
        assertEquals(452137076, s.trailingZeroes(1808548329));
    }
}
