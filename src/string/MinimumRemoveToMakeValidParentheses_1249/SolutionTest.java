package string.MinimumRemoveToMakeValidParentheses_1249;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("lee(t(c)o)de", s.minRemoveToMakeValid("lee(t(c)o)de)"));
        assertEquals("ab(c)d", s.minRemoveToMakeValid("a)b(c)d"));
        assertEquals("", s.minRemoveToMakeValid("))(("));
        assertEquals("(a(bc)d)", s.minRemoveToMakeValid("(a(b(c)d)"));
    }
}