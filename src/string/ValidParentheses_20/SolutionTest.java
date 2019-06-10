package string.ValidParentheses_20;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.isValid(null));
        assertTrue(s.isValid(""));
        assertTrue(s.isValid("(){}[]"));
        assertTrue(s.isValid("{[]}"));
        assertFalse(s.isValid("(]"));
        assertFalse(s.isValid("([)]"));
        assertFalse(s.isValid("]"));
    }
}
