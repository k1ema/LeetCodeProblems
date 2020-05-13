package stack.RemoveKDigits_402;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("1219", s.removeKdigits("1432219", 3));
        assertEquals("200", s.removeKdigits("10200", 1));
        assertEquals("0", s.removeKdigits("10", 2));
        assertEquals("2", s.removeKdigits("827", 2));
        assertEquals("234563284563", s.removeKdigits("82734563284563", 2));
        assertEquals("2349", s.removeKdigits("88734658236549", 10));
    }
}