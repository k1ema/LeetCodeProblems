package backtracking.WordPattern_II_291;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.wordPatternMatch("abab", "redblueredblue"));
        assertTrue(s.wordPatternMatch("aaaa", "asdasdasdasd"));
        assertFalse(s.wordPatternMatch("aabb", "xyzabcxzyabc"));
        assertTrue(s.wordPatternMatch("aba", "aaaa"));
        assertTrue(s.wordPatternMatch("abc", "bca"));
        assertFalse(s.wordPatternMatch("ab", "aa"));
    }
}