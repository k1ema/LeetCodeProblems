package string.ThousandSeparator_1556;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("987", s.thousandSeparator(987));
        assertEquals("1.234", s.thousandSeparator(1234));
        assertEquals("123.456.789", s.thousandSeparator(123456789));
        assertEquals("0", s.thousandSeparator(0));
        assertEquals("21.054", s.thousandSeparator(21054));
    }
}