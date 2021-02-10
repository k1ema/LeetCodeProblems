package dynamic.RegularExpressionMatching_10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertFalse(s.isMatch("aa", "a"));
        assertTrue(s.isMatch("aa", "a*"));
        assertTrue(s.isMatch("ab", ".*"));
        assertTrue(s.isMatch("aab", "c*a*b"));
        assertFalse(s.isMatch("mississippi", "mis*is*p*."));
        assertTrue(s.isMatch("aabe", "c*a*b."));
        assertTrue(s.isMatch("abc", ".*"));
        assertTrue(s.isMatch("aaa", "ab*ac*a"));
        assertFalse(s.isMatch("aaba", "ab*a*c*a"));
    }
}
