package string.LastSubstringInLexicographicalOrder_1163;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("bab", s.lastSubstring("abab"));
        assertEquals("tcode", s.lastSubstring("leetcode"));
    }
}