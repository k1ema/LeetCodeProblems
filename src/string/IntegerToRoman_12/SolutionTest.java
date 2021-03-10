package string.IntegerToRoman_12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("III", s.intToRoman(3));
        assertEquals("IV", s.intToRoman(4));
        assertEquals("V", s.intToRoman(5));
        assertEquals("VI", s.intToRoman(6));
        assertEquals("IX", s.intToRoman(9));
        assertEquals("X", s.intToRoman(10));
        assertEquals("XI", s.intToRoman(11));
        assertEquals("LVIII", s.intToRoman(58));
        assertEquals("MCMXCIV", s.intToRoman(1994));
        assertEquals("XX", s.intToRoman(20));
        assertEquals("XXX", s.intToRoman(30));
        assertEquals("XL", s.intToRoman(40));
        assertEquals("LX", s.intToRoman(60));
        assertEquals("LXI", s.intToRoman(61));
        assertEquals("LXIII", s.intToRoman(63));
        assertEquals("LXIV", s.intToRoman(64));
    }
}