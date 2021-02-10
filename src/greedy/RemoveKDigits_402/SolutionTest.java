package greedy.RemoveKDigits_402;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("199", s.removeKdigits("421999", 3));
        assertEquals("1234", s.removeKdigits("1234567", 3));
        assertEquals("1219", s.removeKdigits("1432219", 3));
        assertEquals("200", s.removeKdigits("10200", 1));
        assertEquals("0", s.removeKdigits("10", 2));
        assertEquals("2", s.removeKdigits("827", 2));
        assertEquals("234563284563", s.removeKdigits("82734563284563", 2));
        assertEquals("2349", s.removeKdigits("88734658236549", 10));
        assertEquals("0", s.removeKdigits("1234567890", 9));
    }
}