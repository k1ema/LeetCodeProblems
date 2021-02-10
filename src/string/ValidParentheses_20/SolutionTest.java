package string.ValidParentheses_20;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
