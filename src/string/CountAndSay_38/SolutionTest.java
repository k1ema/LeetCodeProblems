package string.CountAndSay_38;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("1", s.countAndSay(1));
        assertEquals("11", s.countAndSay(2));
        assertEquals("21", s.countAndSay(3));
        assertEquals("1211", s.countAndSay(4));
        assertEquals("111221", s.countAndSay(5));
        assertEquals("312211", s.countAndSay(6));
        assertEquals("13211311123113112211", s.countAndSay(10));
    }
}
