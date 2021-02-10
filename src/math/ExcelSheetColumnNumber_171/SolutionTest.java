package math.ExcelSheetColumnNumber_171;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.titleToNumber("A"));
        assertEquals(28, s.titleToNumber("AB"));
        assertEquals(701, s.titleToNumber("ZY"));
        assertEquals(Integer.MAX_VALUE, s.titleToNumber("FXSHRXW"));
    }
}