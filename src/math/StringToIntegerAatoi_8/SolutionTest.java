package math.StringToIntegerAatoi_8;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(42, s.myAtoi("42"));
        assertEquals(-42, s.myAtoi("   -42"));
        assertEquals(4193, s.myAtoi("4193 with words"));
        assertEquals(Integer.MIN_VALUE, s.myAtoi("-91283472332"));
        assertEquals(Integer.MAX_VALUE, s.myAtoi("91283472332"));
        assertEquals(-12, s.myAtoi("  -0012a42"));
        assertEquals(Integer.MIN_VALUE, s.myAtoi("-6147483648"));
        assertEquals(Integer.MAX_VALUE, s.myAtoi("    10522545459"));
        assertEquals(0, s.myAtoi(""));
        assertEquals(0, s.myAtoi(" "));
    }
}
