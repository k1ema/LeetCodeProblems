package string.ZigZagConversion_6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("PAHNAPLSIIGYIR", s.convert("PAYPALISHIRING", 3));
        assertEquals("PINALSIGYAHRPI", s.convert("PAYPALISHIRING", 4));
    }
}
