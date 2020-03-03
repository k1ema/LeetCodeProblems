package math.ReverseInteger_7;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(123, s.reverse(321));
        assertEquals(321, s.reverse(123));
        assertEquals(21, s.reverse(120));
        assertEquals(21, s.reverse(120));
        assertEquals(0, s.reverse(0));
        assertEquals(0, s.reverse(Integer.MAX_VALUE));
        assertEquals(0, s.reverse(Integer.MAX_VALUE - 1));
        assertEquals(0, s.reverse(Integer.MIN_VALUE));
        assertEquals(0, s.reverse(Integer.MIN_VALUE + 1));
    }
}