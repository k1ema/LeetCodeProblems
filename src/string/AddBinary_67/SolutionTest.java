package string.AddBinary_67;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("100", s.addBinary("11", "1"));
        assertEquals("10101", s.addBinary("1010", "1011"));
        assertEquals("1010", s.addBinary("111", "11"));
        assertEquals("1000", s.addBinary("101", "11"));
    }
}
