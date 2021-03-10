package string.RomanToInteger_13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.romanToInt("I"));
        assertEquals(3, s.romanToInt("III"));
        assertEquals(4, s.romanToInt("IV"));
        assertEquals(5, s.romanToInt("V"));
        assertEquals(6, s.romanToInt("VI"));
        assertEquals(9, s.romanToInt("IX"));
        assertEquals(10, s.romanToInt("X"));
        assertEquals(12, s.romanToInt("XII"));
        assertEquals(58, s.romanToInt("LVIII"));
        assertEquals(1994, s.romanToInt("MCMXCIV"));
    }
}