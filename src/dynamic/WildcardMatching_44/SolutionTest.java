package dynamic.WildcardMatching_44;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.isMatch("abcdef", "abcdef"));
        assertTrue(s.isMatch("abcdef", "ab?def"));
        assertTrue(s.isMatch("abxyz", "ab???"));
        assertTrue(s.isMatch("fhr", "???"));
        assertFalse(s.isMatch("aa", "a"));
        assertTrue(s.isMatch("aa", "*"));
        assertFalse(s.isMatch("cb", "?a"));
        assertTrue(s.isMatch("adceb", "*a*b"));
        assertTrue(s.isMatch("", "*"));
        assertTrue(s.isMatch("", "**"));
        assertFalse(s.isMatch("", "?"));
        assertFalse(s.isMatch("acdcb", "a*c?b"));
        assertTrue(s.isMatch("acdcbq", "a*c??*"));
        assertFalse(s.isMatch("abc", "*abc?*"));
        assertTrue(s.isMatch("abbabbbaabaaabbbbbabbabbabbbabbaaabbbababbabaaabbab", "*aabb***aa**a******aa*"));
    }
}
