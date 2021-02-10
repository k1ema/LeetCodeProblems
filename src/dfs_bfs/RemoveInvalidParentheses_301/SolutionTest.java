package dfs_bfs.RemoveInvalidParentheses_301;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList("(())()", "()()()"), s.removeInvalidParentheses("()())()"));
        assertEquals(Arrays.asList("(a())()", "(a)()()"), s.removeInvalidParentheses("(a)())()"));
        assertEquals(Collections.singletonList(""), s.removeInvalidParentheses(")("));
        assertEquals(Collections.singletonList("()"), s.removeInvalidParentheses("))((()"));
    }
}