package stack.LongestValidParentheses_32;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(4, s.longestValidParentheses("()()"));
        assertEquals(2, s.longestValidParentheses("(()"));
        assertEquals(4, s.longestValidParentheses(")()())"));
        assertEquals(6, s.longestValidParentheses("(()())"));
        assertEquals(4, s.longestValidParentheses("()())"));
        assertEquals(4, s.longestValidParentheses("(()()"));
        assertEquals(2, s.longestValidParentheses("()(()"));
    }
}